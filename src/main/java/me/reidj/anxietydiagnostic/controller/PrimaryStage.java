package me.reidj.anxietydiagnostic.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public record PrimaryStage(Stage stage) {

    public void setScene(Scene scene) {
        stage.setScene(scene);
        stage.setOnHidden(event -> Platform.exit());
        stage.sizeToScene();
        stage.setTitle("Диагностика Уровня Тревожности");
        stage.setResizable(false);
        show();
    }

    public void showScene(Scene scene) {
        stage.setScene(scene);
        show();
    }

    public void showAlert(Alert.AlertType alertType, String contextText, String headerText) {
        Alert alert = new Alert(alertType, contextText);
        alert.setTitle(alertType == Alert.AlertType.ERROR ? "Ошибка!" : "Успешно!");
        alert.setHeaderText(headerText);
        alert.show();
    }

    public void show() {
        stage.show();
    }
}
