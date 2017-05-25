package com.oneler.lambda;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by opure on 2017/4/18.
 */
public class MaxLength {
    public void read() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(MaxLength.class.getResource("/a.html").getFile()));
            int longlength = bufferedReader.lines()
                    .mapToInt(String::length)
                    .max()
                    .getAsInt();
            bufferedReader.close();
            System.out.println(longlength);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tranlate() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\ebay1\\lambdajava8\\target\\classes\\b.txt"));
            List<String> words = bufferedReader.lines().
                    flatMap(line -> Stream.of(line.split(" "))).
                    filter(word -> word.length() > 0).
                    map(String::toLowerCase).
                    distinct()
                    .sorted()
                    .collect(Collectors.toList());
            bufferedReader.close();
            System.out.println(words);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Stream.generate(() -> Math.random()).limit(10).forEach(x-> System.out.println(x+"fff"));
        System.out.println(ClassLoader. getSystemClassLoader());
        System.out.println( System.getProperty("user.dir"));
        File file3 = new File(MaxLength.class.getResource("/a.html").getFile());
        new MaxLength().tranlate();
        List<String> a = new ArrayList<>();
        a.add("fdsaf");
        System.out.println(a);

        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        //Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);
        final long l = System.currentTimeMillis();
        final int i = (int)( l % 10 );
        System.out.println("i"+i);


        Stream.iterate(0, n -> n + 3).limit(10). forEach(x -> System.out.print(x + " "));
/*
        Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
                limit(100).
                collect(Collectors.groupingBy(Person::getAge));
        Iterator it = personGroups.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Person>> persons = (Map.Entry) it.next();
            System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
        }*/

        System.out.println("dd"+"中1".getBytes().length);

        IntStream.range(1, 3).forEach(System.out::println);
        ArrayList aa = new ArrayList();
        Stream.iterate(0,n -> n+1).limit(1001).forEach(x ->aa.add(x));
        List<List<Integer>> partition = com.google.common.collect.Lists.partition(aa, 100);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        new File(".").listFiles(File::isHidden);

        new Thread(() -> System.out.println("aa"));
    }



}
