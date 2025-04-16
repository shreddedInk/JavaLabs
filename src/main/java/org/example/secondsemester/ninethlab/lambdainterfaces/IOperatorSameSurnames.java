package org.example.secondsemester.ninethlab.lambdainterfaces;

import org.example.secondsemester.ninethlab.Human;

@FunctionalInterface
public interface IOperatorSameSurnames {
    Boolean apply(Human human1, Human human2);
}
