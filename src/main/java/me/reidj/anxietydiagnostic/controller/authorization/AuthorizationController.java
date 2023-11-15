package me.reidj.anxietydiagnostic.controller.authorization;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import me.reidj.anxietydiagnostic.controller.AbstractScene;

public class AuthorizationController extends AbstractScene {

    @FXML
    private Label welcomeText;

    public AuthorizationController() {
        super("authorization/authorizationScene.fxml");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
