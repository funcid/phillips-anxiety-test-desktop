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

    private int sum1 = 0;
    private int sum2 = 0;
    private int sum3 = 0;
    private int sum4 = 0;
    private int sum5 = 0;
    private int sum6 = 0;
    private int sum7 = 0;
    private int sum8 = 0;

    @FXML
    private void initialize() {
        Factors.LOW_PHYSIOLOGICAL_RESISTANCE_STRESS.getIndexes().forEach(index ->
                App.getApp().getUser().questions().forEach((question, s) -> {
                    if (index == question.getIndex() && !question.getAnswer().equalsIgnoreCase(s)) {
                        sum1++;
                        if (sum1 == Factors.LOW_PHYSIOLOGICAL_RESISTANCE_STRESS.getSum()) {
                            resultLabel.setText(Factors.LOW_PHYSIOLOGICAL_RESISTANCE_STRESS.getTitle());
                        }
                    }
                }));
        Factors.EXPERIENCING_SOCIAL_STRESS.getIndexes().forEach(index ->
                App.getApp().getUser().questions().forEach((question, s) -> {
                    if (index == question.getIndex() && !question.getAnswer().equalsIgnoreCase(s)) {
                        sum2++;
                        if (sum2 == Factors.EXPERIENCING_SOCIAL_STRESS.getSum()) {
                            resultLabel.setText(Factors.EXPERIENCING_SOCIAL_STRESS.getTitle());
                        }
                    }
                }));
        Factors.FRUSTRATION_NEED_ACHIEVE_SUCCESS.getIndexes().forEach(index ->
                App.getApp().getUser().questions().forEach((question, s) -> {
                    if (index == question.getIndex() && !question.getAnswer().equalsIgnoreCase(s)) {
                        sum3++;
                        if (sum3 == Factors.FRUSTRATION_NEED_ACHIEVE_SUCCESS.getSum()) {
                            resultLabel.setText(Factors.FRUSTRATION_NEED_ACHIEVE_SUCCESS.getTitle());
                        }
                    }
                }));
        Factors.FEAR_SELF_EXPRESSION.getIndexes().forEach(index ->
                App.getApp().getUser().questions().forEach((question, s) -> {
                    if (index == question.getIndex() && !question.getAnswer().equalsIgnoreCase(s)) {
                        sum4++;
                        if (sum4 == Factors.FEAR_SELF_EXPRESSION.getSum()) {
                            resultLabel.setText(Factors.FEAR_SELF_EXPRESSION.getTitle());
                        }
                    }
                }));
        Factors.FEAR_KNOWLEDGE_TESTING_SITUATION.getIndexes().forEach(index ->
                App.getApp().getUser().questions().forEach((question, s) -> {
                    if (index == question.getIndex() && !question.getAnswer().equalsIgnoreCase(s)) {
                        sum5++;
                        if (sum5 == Factors.FEAR_KNOWLEDGE_TESTING_SITUATION.getSum()) {
                            resultLabel.setText(Factors.FEAR_KNOWLEDGE_TESTING_SITUATION.getTitle());
                        }
                    }
                }));
        Factors.FEAR_NOT_MEETING_EXPECTATIONS_OTHERS.getIndexes().forEach(index ->
                App.getApp().getUser().questions().forEach((question, s) -> {
                    if (index == question.getIndex() && !question.getAnswer().equalsIgnoreCase(s)) {
                        sum6++;
                        if (sum6 == Factors.FEAR_NOT_MEETING_EXPECTATIONS_OTHERS.getSum()) {
                            resultLabel.setText(Factors.FEAR_NOT_MEETING_EXPECTATIONS_OTHERS.getTitle());
                        }
                    }
                }));
        Factors.LOW_PHYSIOLOGICAL_RESISTANCE_STRESS.getIndexes().forEach(index ->
                App.getApp().getUser().questions().forEach((question, s) -> {
                    if (index == question.getIndex() && !question.getAnswer().equalsIgnoreCase(s)) {
                        sum7++;
                        if (sum7 == Factors.PROBLEMS_AND_FEARS_RELATIONSHIPS_WITH_TEACHERS.getSum()) {
                            resultLabel.setText(Factors.PROBLEMS_AND_FEARS_RELATIONSHIPS_WITH_TEACHERS.getTitle());
                        }
                    }
                }));
        Factors.PROBLEMS_AND_FEARS_RELATIONSHIPS_WITH_TEACHERS.getIndexes().forEach(index ->
                App.getApp().getUser().questions().forEach((question, s) -> {
                    if (index == question.getIndex() && !question.getAnswer().equalsIgnoreCase(s)) {
                        sum8++;
                        if (sum8 == Factors.PROBLEMS_AND_FEARS_RELATIONSHIPS_WITH_TEACHERS.getSum()) {
                            resultLabel.setText(Factors.PROBLEMS_AND_FEARS_RELATIONSHIPS_WITH_TEACHERS.getTitle());
                        }
                    }
                }));
    }
}
