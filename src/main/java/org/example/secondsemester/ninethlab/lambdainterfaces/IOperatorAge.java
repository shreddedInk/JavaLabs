package org.example.secondsemester.ninethlab.lambdainterfaces;

import org.example.secondsemester.ninethlab.Human;

@FunctionalInterface
public interface IOperatorAge {
    Integer apply(Human human);
}
