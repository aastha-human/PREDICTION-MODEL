import java.io.FileInputStream;
import java.util.Properties;

public class StockPredictionApp {
    public static void main(String[] args) {
        try {
           
            Properties config = new Properties();
            config.load(new FileInputStream("./src/main/resources/config.properties"));

            
            PythonIntegration pythonIntegration = new PythonIntegration(config);

            // Preprocessing
            System.out.println("Running preprocessing...");
            String preprocessOutput = pythonIntegration.runPythonScript("preprocess_data.py");
            System.out.println(preprocessOutput);

      
            System.out.println("Running training...");
            String trainOutput = pythonIntegration.runPythonScript("train_model.py");
            System.out.println(trainOutput);

            
            System.out.println("Running prediction...");
            String predictOutput = pythonIntegration.runPythonScript("predict_stock.py");
            System.out.println(predictOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
