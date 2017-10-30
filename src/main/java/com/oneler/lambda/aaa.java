package com.oneler.lambda;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class aaa {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(5L) % 1);
        System.out.println(3 % 1);

        List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        IntSummaryStatistics iss = list.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println(iss);

        Stream<int[]> data =
                IntStream.rangeClosed(1, 100)
                        .boxed()
                        .flatMap(x ->
                                    IntStream.rangeClosed(x, 100)
                                            .filter(b -> Math.sqrt(b * b + x * x) % 1 == 0)
                                            .mapToObj(b ->
                                                    new int[]{x, b, (int) Math.sqrt(b * b + x * x)})
                        );
        data.limit(10).forEach(ints -> System.out.println(ints[0]+"fd" +ints[1] + ints[2]));

    }
}
