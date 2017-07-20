package com.oneler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootApplication
public class LambdaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LambdaApplication.class, args);
		float f1 = 0.9999999f;
		float f2 = 1f;
		System.out.println(f1==f2);
		boolean value = (Float.floatToIntBits(f1) == Float.floatToIntBits(f2));
		System.out.println(value);
		Stream<String> stream = Stream.of("a", "b", "c");
		Set<String> seen = Collections.synchronizedSet(new HashSet<>());
	}
}
