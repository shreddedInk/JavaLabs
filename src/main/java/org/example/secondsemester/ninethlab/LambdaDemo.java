package org.example.secondsemester.ninethlab;

import org.example.secondsemester.ninethlab.lambdainterfaces.*;

public class LambdaDemo {
    public static final IOperatorLength string_length = String::length;

    public static final IOperatorFirstLetter string_first_letter = s -> {
        if (s == null || s.isEmpty()){
            return null;
        }
        return s.charAt(0);
    };

    public static final IOperatorSpaces string_no_spaces = s -> s.contains(" ");

    public static final IOperatorWordsCount string_count_of_words = s -> s.split(",").length;

    public static final IOperatorAge human_age = Human::getAge;

    public static final IOperatorSameSurnames human_same_surnames =
            (h1, h2) -> h1 != null && h2 != null &&
                    h1.getLastName().equals(h2.getLastName());

    public static final IOperatorGetFullName human_get_full_name = s -> s.getLastName()+" "+s.getFirstName()+" "+s.getMiddleName();

    public static final IOperatorMakeOlder human_make_older = s -> {
        if (s == null) return null;
        return new Human(
                s.getLastName(),
                s.getFirstName(),
                s.getMiddleName(),
                s.getAge() + 1,
                s.getGender()
        );
    };

    public static final IOperatorAgeChecker human_age_checker = (h1, h2, h3, maxAge) ->
            h1.getAge() < maxAge &&
            h2.getAge() < maxAge &&
            h3.getAge() < maxAge;
}
