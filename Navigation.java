package registration;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Navigation {
    private final Stage primaryStage;

    public Navigation(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene getHomePage() {
        StackPane mainPane = new StackPane();
        mainPane.setId("main-pane");

        // Background image
        Image i = new Image("background.jpg");
        ImageView background = new ImageView(i);
        background.setFitWidth(800);
        background.setFitHeight(500);
        background.setPreserveRatio(false);

        // Welcome text
        Button loginButton = new Button("Login");
        loginButton.setId("home-button");
        loginButton.setPrefSize(200, 50);
        loginButton.setOnAction(e -> primaryStage.setScene(getLoginPage()));

        Button registerButton = new Button("Register");
        registerButton.setId("home-button");
        registerButton.setPrefSize(200, 50);
        registerButton.setOnAction(e -> primaryStage.setScene(getRegisterPage()));

        VBox buttons = new VBox(20, loginButton, registerButton);
        buttons.setId("home-buttons");
        buttons.setAlignment(javafx.geometry.Pos.CENTER);

        mainPane.getChildren().addAll(background, buttons);
        return new Scene(mainPane, 800, 500);
    }

    public Scene getLoginPage() {
        return new Scene(new LoginRegisterPage(primaryStage, this).createLoginForm(), 800, 500);
    }

    public Scene getRegisterPage() {
        return new Scene(new LoginRegisterPage(primaryStage, this).createRegisterForm(), 800, 500);
    }
}
