package com.oneler.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Java78FileReadingExample {
    public static void main(String args[]) throws IOException {

        //System.out.println(new String(Files.readAllBytes(Paths.get("data_old.txt"))));
        // System.out.println(new String(Files.readAllBytes(Paths.get("info.xml"))));
        List<String> lines = Files.readAllLines(Paths.get("data_old.txt"), StandardCharsets.UTF_8);
        Files.readAllLines(Paths.get("data_old.txt"), StandardCharsets.UTF_8).forEach(x -> {
            System.out.println(x);
        });
  /*      StringBuilder sb = new StringBuilder(1024);
        for (String line : lines) {
            sb.append(line);
        }
        String fromFile = sb.toString();
        System.out.println("++++++++++++++++++++++++");
        System.out.println("String created by reading File in Java");
        System.out.println(fromFile);
        System.out.println("++++++++++++++++++++++++");
    }*/
    }
}

