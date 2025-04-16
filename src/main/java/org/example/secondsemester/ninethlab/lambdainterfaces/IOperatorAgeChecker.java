package org.example.secondsemester.ninethlab.lambdainterfaces;

import org.example.secondsemester.ninethlab.Human;

@FunctionalInterface
public interface IOperatorAgeChecker {
    boolean apply(Human h1, Human h2, Human h3, int maxAge);
}
