package me.reidj.anxietydiagnostic.controller.result;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import me.reidj.anxietydiagnostic.App;
import me.reidj.anxietydiagnostic.controller.AbstractScene;
import me.reidj.anxietydiagnostic.factor.Factors;

public class ResultController extends AbstractScene {

    @FXML
    private Label resultLabel;

    public ResultController() {
        super("result/resultScene.fxml");
    }

    private final int[] sums = new int[Factors.values().length];

    @FXML
    private void initialize() {
        for (Factors factor : Factors.values()) {
            factor.getIndexes().forEach(index -> acceptFactor(factor, index));
        }
    }

    private void acceptFactor(Factors factor, int index) {
        App.getApp().getUser().questions().forEach((question, s) -> {
            if (index == question.index && !question.answer.equals(s)) {
                sums[factor.ordinal()]++;
                if (sums[factor.ordinal()] == factor.getSum()) {
                    resultLabel.setText(factor.getTitle());
                }
            }
        });
    }
}
