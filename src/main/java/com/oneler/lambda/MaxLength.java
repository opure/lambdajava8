package com.oneler.lambda;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm;

import javax.validation.constraints.Max;
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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(MaxLength.class.getResource("/a.txt").getFile()));
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
        System.out.println(ClassLoader. getSystemClassLoader());
        System.out.println( System.getProperty("user.dir"));
        File file3 = new File(MaxLength.class.getResource("/a.txt").getFile());
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
    }
}
