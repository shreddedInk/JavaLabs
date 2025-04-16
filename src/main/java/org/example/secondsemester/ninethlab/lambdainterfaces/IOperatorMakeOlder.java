package org.example.secondsemester.ninethlab.lambdainterfaces;

import org.example.secondsemester.ninethlab.Human;

@FunctionalInterface
public interface IOperatorMakeOlder {
    Human apply(Human human);
}
