package com.oneler.lambda.filter;

import java.util.*;

/**
 * Created by opure on 2017/5/25.
 */
public class Test {
    public static void main(String[] args) {
/*        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        List<String> list1 = new ArrayList<>();
        list1.add("2");
        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("1");
        lists.add(list);
        lists.add(list1);
        lists.add(list2);

        List<List<String>> collect = lists.parallelStream().filter(x -> x.contains("1")).collect(toList());
        System.out.println(collect);

        List<Integer> a1 = Arrays.asList(1, 2, 3);
        List<Integer> a2 = Arrays.asList(4, 5);

        final List<int[]> collect1 = a1.stream()
                .flatMap(i -> a2.stream().map(j -> new int[]{i, j}))
                .collect(toList());
        int[] a = new int[]{1, 2};*/
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(5);
        list3.add(6);
        list3.add(8);
        list3.add(9);
        list3.add(12);
        list3.add(13);
        list3.add(14);
        Iterator iter = list3.iterator();
        Map<Integer, String> map = new HashMap<>();
        Integer pre;
        while (iter.hasNext()) {
            String temp = "";
            Integer str = (Integer) iter.next();
            int i = str + 1;
            Integer next = (Integer) iter.next();
            Integer defaultValue = str;
            if (i == next) {
                temp = defaultValue + "~" + next;
            } else {
                defaultValue = next;
            }
            pre = i;
            map.put(defaultValue, temp);
            System.out.println(map);
        }

    }

}