package org.example.secondsemester.ninethlab;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamApiDemo extends LambdaDemo {

    public static final UnaryOperator<List<Object>> remove_nulls =
            list -> list.stream().filter(Objects::nonNull).collect(Collectors.toList());

    public static final Function<Set<Integer>, Long> count_positive_numbers =
            set -> set.stream().filter(x -> x > 0).count();

    public static final UnaryOperator<List<Object>> last_three_elements =
            list -> list.stream()
                    .skip(Math.max(0, list.size() - 3))
                    .collect(Collectors.toList());

    public static final Function<List<Integer>, Integer> first_even_or_null =
            list -> list.stream().filter(x -> x % 2 == 0).findFirst().orElse(null);

    public static final Function<int[], List<Integer>> unique_squares =
            array -> IntStream.of(array)
                    .map(x -> x * x)
                    .distinct()
                    .boxed()
                    .collect(Collectors.toList());

    public static final Function<List<String>, List<String>> sorted_non_empty_strings =
            list -> list.stream()
                    .filter(s -> s != null && !s.isEmpty())
                    .sorted()
                    .collect(Collectors.toList());

    public static final Function<Set<String>, List<String>> sorted_descending_strings =
            set -> set.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

    public static final ToIntFunction<Set<Integer>> sum_of_squares =
            set -> set.stream().mapToInt(x -> x * x).sum();

    public static final Function<Collection<Human>, Integer> max_human_age =
            list -> list.stream()
                    .mapToInt(Human::getAge)
                    .max()
                    .orElse(0);

    public static final UnaryOperator<List<Human>> sort_by_gender_then_age =
            list -> list.stream()
                    .sorted(Comparator.comparing(Human::getGender)
                            .thenComparing(Human::getAge))
                    .collect(Collectors.toList());
}
