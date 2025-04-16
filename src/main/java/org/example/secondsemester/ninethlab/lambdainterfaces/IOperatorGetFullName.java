package org.example.secondsemester.ninethlab.lambdainterfaces;

import org.example.secondsemester.ninethlab.Human;

@FunctionalInterface
public interface IOperatorGetFullName {
    String apply(Human human);
}
