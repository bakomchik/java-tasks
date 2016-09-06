package ru.mikryukov.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by evgeniy.mikryukov on 06.09.16.
 */
public class SimpleGrep {
    public static void main(String args[]) {

        String fileName = args[0];
        String subString = args[1];
        List<String> list = new ArrayList<>();

        if (Files.notExists(Paths.get(fileName))) {
            System.out.println("There is no file with name " + fileName);
        } else {
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

                list = stream
                        .filter(line -> line.contains(subString))
                        .collect(Collectors.toList());
                //I'm no write subString in Output, because i would like to save values in the list

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!list.isEmpty()) {
                list.forEach(System.out::println);
            } else {
                System.out.println("There is no matches of " + subString + " in the file " + fileName);
            }

        }
    }
}