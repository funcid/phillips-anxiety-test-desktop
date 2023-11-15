package me.reidj.anxietydiagnostic.exception;

import javafx.scene.control.Alert;
import lombok.AllArgsConstructor;
import me.reidj.anxietydiagnostic.App;

@AllArgsConstructor
public enum Errors implements Solid {
    FIELD_EMPTY(new FieldIsEmpty())
    ;

    private final Solid solid;

    @Override
    public boolean check(String... strings) {

        boolean bool = solid.check(strings);

        if (bool) {

            String[] message = solid.getMessage();

            App.getApp().getPrimaryStage().showAlert(
                    Alert.AlertType.ERROR,
                    message[0],
                    message[1]
            );
        }

        return bool;
    }

    public boolean checkWithoutAlert(String... strings) {
        return solid.check(strings);
    }

    @Override
    public String[] getMessage() {
        return solid.getMessage();
    }
}
