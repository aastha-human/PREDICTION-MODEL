import java.io.FileInputStream;
import java.util.Properties;

public class StockPredictionApp {
    public static void main(String[] args) {
        try {
            // Load configuration
            Properties config = new Properties();
            config.load(new FileInputStream("./src/main/resources/config.properties"));

            // Initialize Python integration
            PythonIntegration pythonIntegration = new PythonIntegration(config);

            // Run preprocessing
            System.out.println("Running preprocessing...");
            String preprocessOutput = pythonIntegration.runPythonScript("preprocess_data.py");
            System.out.println(preprocessOutput);

            // Run training
            System.out.println("Running training...");
            String trainOutput = pythonIntegration.runPythonScript("train_model.py");
            System.out.println(trainOutput);

            // Run prediction
            System.out.println("Running prediction...");
            String predictOutput = pythonIntegration.runPythonScript("predict_stock.py");
            System.out.println(predictOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
