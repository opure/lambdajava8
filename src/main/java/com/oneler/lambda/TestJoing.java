package com.oneler.lambda;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by opure on 2017/4/20.
 */
public class TestJoing {
    public static void main(String[] args) {
        System.out.println(Arrays.asList("12","214"));
        List<String> stringList = new ArrayList<>();
        List<String> l = new ArrayList(Arrays.asList("123455", "1","123"));
        Stream<String> sl = l.stream();
     /*   sl.reduce("",String::concat);
        //String s = sl.collect(joining(","));
        System.out.println("s1"+l);

        //System.out.println(s);
        System.out.println("dd"+l.stream().max(String::compareTo).get());*/

/*        List<String> strings = sl.map(Object::toString)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);*/
        ArrayList<String> strings = sl.collect(() -> new ArrayList<>(),
                (c, e) -> c.add(e.toString()),
                (c1, c2) -> c1.addAll(c2));
        System.out.println("strings"+strings);
        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);

        Stream.iterate(1, item -> item + 10).limit(10).forEach(System.out::println);
    }





}
