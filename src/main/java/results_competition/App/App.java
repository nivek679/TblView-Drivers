package results_competition.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/results_competition/view/resources/results_competitionView/tablaConductoresView.fxml"));
        Parent root = loader.load();
        // Configura la escena y la muestra
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tabla Conductores");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}