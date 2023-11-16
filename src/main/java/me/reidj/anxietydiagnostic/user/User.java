package me.reidj.anxietydiagnostic.user;

import me.reidj.anxietydiagnostic.question.Question;

import java.util.Map;

public record User(String name, String surname, String patronymic, String classroom, Map<Question, String> questions) {
}
