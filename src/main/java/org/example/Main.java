package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        Stream<Integer> stream = new ArrayList<>(Arrays.asList(14, 2, 3, 5, 8, 13, 2434)).stream();
        findMinMax(
                stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y))
        );

        evenNumbers(1,3, 6,8, 11, 14);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList = new ArrayList<>();
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
            minMaxConsumer.accept(min, max);
            if (min == null && max == null) {
                minMaxConsumer.accept(null, null);
            }
        }
    }

    public static void evenNumbers(Integer... n) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(n));
        List<Integer> num = numbers.stream().filter(e -> (e % 2 == 0)).toList();
        System.out.println("Количество чётных чисел: " + num.size());
    }
}