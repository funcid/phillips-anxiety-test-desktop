package me.reidj.anxietydiagnostic.controller.authorization;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import me.reidj.anxietydiagnostic.App;
import me.reidj.anxietydiagnostic.controller.AbstractScene;
import me.reidj.anxietydiagnostic.exception.Errors;
import me.reidj.anxietydiagnostic.user.User;

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
        if (Errors.FIELD_EMPTY.check(patronymic))
            return;
        if (Errors.FIELD_EMPTY.check(classroom))
            return;

        App.getApp().setUser(new User(name, surname, patronymic, classroom));
    }
}
