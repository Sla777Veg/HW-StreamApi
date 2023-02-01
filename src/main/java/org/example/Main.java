package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        findMinMax(Stream.of(1, 8,34, 88), Integer::compareTo, (min, max) -> {
            System.out.printf("min: %d, max: %d", min, max);
        });
        System.out.println("\n");

        evenNumbers(1,3, 6,8, 11, 14);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
    }

    public static void evenNumbers(Integer... n) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(n));
        List<Integer> num = numbers.stream().filter(e -> (e % 2 == 0)).toList();
        System.out.println("Количество чётных чисел: " + num.size());
    }

}