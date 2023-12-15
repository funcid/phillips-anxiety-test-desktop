package me.func.anxietydiagnostic.factor;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;

@AllArgsConstructor
@Getter
public enum Factors {
    GENERAL_ANXIETY_SCHOOL("Общая тревожность в школе", new HashSet<>(Arrays.asList(
            2, 3, 7, 12, 16, 21, 23, 26, 28, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58
    )), 22),
    EXPERIENCING_SOCIAL_STRESS("Переживание социального стресса", new HashSet<>(Arrays.asList(
            5, 10, 15, 20, 24, 30, 33, 36, 39, 42, 44
    )), 11),
    FRUSTRATION_NEED_ACHIEVE_SUCCESS("Фтрустрация потребности в достижении успеха", new HashSet<>(Arrays.asList(
            1, 3, 6, 11, 17, 19, 25, 29, 32, 35, 38, 41, 43
    )), 13),
    FEAR_SELF_EXPRESSION("Страх самовыражения", new HashSet<>(Arrays.asList(
            27, 31, 34, 37, 40, 45
    )), 6),
    FEAR_KNOWLEDGE_TESTING_SITUATION("Страх ситуации проверки знаний", new HashSet<>(Arrays.asList(
            2, 7, 12, 16, 21, 26
    )), 6),
    FEAR_NOT_MEETING_EXPECTATIONS_OTHERS("Страх не соответсвовать ожиданиям окружающих", new HashSet<>(Arrays.asList(
            3, 8, 13, 17, 22
    )), 5),
    LOW_PHYSIOLOGICAL_RESISTANCE_STRESS("Низкая физиологическая сопротивляемость стрессу", new HashSet<>(Arrays.asList(
            9, 14, 18, 23, 28
    )), 5),
    PROBLEMS_AND_FEARS_RELATIONSHIPS_WITH_TEACHERS("Проблемы и страхи в отношениях с учителями", new HashSet<>(Arrays.asList(
            2, 6, 11, 32, 35, 41, 44, 47
    )), 8);

    private final String title;
    private final HashSet<Integer> indexes;
    private final int sum;
}
