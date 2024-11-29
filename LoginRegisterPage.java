package registration;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.*;

public class LoginRegisterPage {

    private final Stage stage;
    private final Navigation navigation;

    public LoginRegisterPage(Stage stage, Navigation navigation) {
        this.stage = stage;
        this.navigation = navigation;
    }

    public VBox createRegisterForm() {
        Label registerLabel = new Label("Register");
        registerLabel.setFont(new Font("Arial", 26));
        registerLabel.setId("form-title");

        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");
        nameField.setMaxSize(250, 70);
        nameField.setId("input-field");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.setMaxSize(250, 70);
        emailField.setId("input-field");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMaxSize(250, 70);
        passwordField.setId("input-field");

        Button registerButton = new Button("Sign Up");
        registerButton.setId("action-button");
        registerButton.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            if (registerUser(name, email, password)) {
                showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "Welcome " + name + "!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Registration Failed", "Email already registered or an error occurred.");
            }
        });

        Button backButton = new Button("Back");
        backButton.setId("back-button");
        backButton.setOnAction(e -> stage.setScene(navigation.getHomePage()));

        VBox form = new VBox(10, registerLabel, nameField, emailField, passwordField, registerButton, backButton);
        form.setAlignment(Pos.CENTER);
        form.setId("form-container");
        return form;
    }

    public VBox createLoginForm() {
        Label loginLabel = new Label("Login");
        loginLabel.setFont(new Font("Arial", 26));
        loginLabel.setId("form-title");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.setMaxSize(250, 50);
        emailField.setId("input-field");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMaxSize(250, 50);
        passwordField.setId("input-field");

        Button loginButton = new Button("Login");
        loginButton.setId("action-button");
        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (checkLogin(email, password)) {
                showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome back!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid credentials. Please try again.");
            }
        });

        Button backButton = new Button("Back");
        backButton.setId("back-button");
        backButton.setOnAction(e -> stage.setScene(navigation.getHomePage()));

        VBox form = new VBox(10, loginLabel, emailField, passwordField, loginButton, backButton);
        form.setAlignment(Pos.CENTER);
        form.setId("form-container");
        return form;
    }

    private boolean registerUser(String name, String email, String password) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/user_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkLogin(String email, String password) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/user_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?")) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
