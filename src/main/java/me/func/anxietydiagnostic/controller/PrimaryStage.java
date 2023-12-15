package me.func.anxietydiagnostic.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public record PrimaryStage(Stage stage) {

    public void setScene(Scene scene) {
        try {
            Class.forName("javafx.application.Application");
        } catch (ClassNotFoundException e) {
            showAlert(
                    Alert.AlertType.ERROR,
                    "Библиотеки JavaFX не найдены. Установите Java с поддержкой JavaFX, например OracleJRE 17 с официального сайта.",
                    "Ошибка"
            );
            System.exit(1);
        }
        stage.setOnHidden(event -> Platform.exit());
        stage.sizeToScene();
        stage.setTitle("Диагностика Уровня Тревожности");
        stage.setResizable(false);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/logo.jpg"))));
        showScene(scene);
    }

    public void showScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public void showAlert(Alert.AlertType alertType, String contextText, String headerText) {
        Alert alert = new Alert(alertType, contextText);
        alert.setTitle(alertType == Alert.AlertType.ERROR ? "Ошибка!" : "Успешно!");
        alert.setHeaderText(headerText);
        alert.show();
    }
}
