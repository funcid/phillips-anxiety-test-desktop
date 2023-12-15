package me.func.anxietydiagnostic.controller.authorization;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import me.func.anxietydiagnostic.controller.AbstractScene;
import me.func.anxietydiagnostic.exception.Errors;
import me.func.anxietydiagnostic.App;
import me.func.anxietydiagnostic.user.User;

import java.util.HashMap;

public class AuthorizationController extends AbstractScene {

    @FXML
    private TextField classroomField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField patronymicField;

    @FXML
    private TextField surnameField;

    public AuthorizationController() {
        super("authorization/authorizationScene.fxml");
    }

    @FXML
    void send() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String patronymic = patronymicField.getText();
        String classroom = classroomField.getText();

        if (Errors.FIELD_EMPTY.check(name))
            return;
        if (Errors.FIELD_EMPTY.check(surname))
            return;
        if (Errors.FIELD_EMPTY.check(classroom))
            return;

        if (App.getApp().getUser() == null) {
            App.getApp().setUser(new User(name, surname, patronymic, classroom, new HashMap<>(),0,0,0));
        }

        App.getApp().getPrimaryStage().showScene(App.getApp().getQuestionController().getScene());
    }
}
