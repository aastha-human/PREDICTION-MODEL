import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class PythonIntegration {

    private String pythonPath;
    private String scriptPath;

    public PythonIntegration(Properties config) {
        this.pythonPath = config.getProperty("python.path", "python");
        this.scriptPath = config.getProperty("script.path", "./scripts/");
    }

    public String runPythonScript(String scriptName, String... args) {
        try {
            // Build the command
            StringBuilder command = new StringBuilder(pythonPath + " " + scriptPath + scriptName);
            for (String arg : args) {
                command.append(" ").append(arg);
            }

            // Execute the command
            Process process = Runtime.getRuntime().exec(command.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();

            // Read the output
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
            return output.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error executing Python script.";
        }
    }
}
