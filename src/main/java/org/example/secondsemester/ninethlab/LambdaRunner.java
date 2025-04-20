package org.example.secondsemester.ninethlab;

import org.example.secondsemester.ninethlab.lambdainterfaces.*;

public class LambdaRunner {
    public static int runStringOperator(IOperatorLength operator, String str) {
        return operator.apply(str);
    }

    public static Character runFirstLetterOperator(IOperatorFirstLetter operator, String str) {
        return operator.apply(str);
    }

    public static boolean runSpacesOperator(IOperatorSpaces operator, String str) {
        return operator.apply(str);
    }

    public static int runWordsCountOperator(IOperatorWordsCount operator, String str) {
        return operator.apply(str);
    }

    public static int runHumanAgeOperator(IOperatorAge operator, Human human) {
        return operator.apply(human);
    }

    public static boolean runSameSurnamesOperator(IOperatorSameSurnames operator, Human h1, Human h2) {
        return operator.apply(h1, h2);
    }

    public static String runFullNameOperator(IOperatorGetFullName operator, Human human) {
        return operator.apply(human);
    }

    public static Human runMakeOlderOperator(IOperatorMakeOlder operator, Human human) {
        return operator.apply(human);
    }

    public static boolean runAgeCheckerOperator(IOperatorAgeChecker operator,
                                                Human h1, Human h2, Human h3,
                                                int maxAge) {
        return operator.apply(h1, h2, h3, maxAge);
    }
}