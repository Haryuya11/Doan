package com.doan.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.doan.controllers.LoginController;

public class App extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(App.class.getResource("/com/doan/views/Login.fxml"));
        Parent root = loader.load();

        if (root == null) {
            throw new RuntimeException("Không thể tải tệp FXML");
        }

        LoginController loginController = loader.getController();
        loginController.setApp(this);

        primaryStage.setTitle("Quản Lý Thư Viện");
        primaryStage.setScene(new Scene(root, 800, 600)); // Điều chỉnh kích thước cửa sổ
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setRoot(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        Parent root = loader.load();
        primaryStage.getScene().setRoot(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
