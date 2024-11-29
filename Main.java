package registration;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Navigation navigation = new Navigation(primaryStage);

        // Load the initial homepage scene
        Scene scene = navigation.getHomePage();
       // scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Set application title and icon
        Image i = new Image("icon.png");
        primaryStage.setTitle("User Registration & Login");
        primaryStage.getIcons().add(i);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
