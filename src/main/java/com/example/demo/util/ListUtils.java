package com.example.demo.util;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListUtils<T> {
    public  <T2> List<T> union(List<T> listLeft, List<T2> listRight, BiPredicate<T, T2> comparable) {
        return listLeft.stream()
                .filter(x -> listRight.stream()
                        .anyMatch(y -> comparable.test(x, y)))
                .collect(Collectors.toList());
    }
}
