package ru.mikryukov.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by evgeniy.mikryukov on 06.09.16.
 */
public class SimpleGrep {
    public static void main(String args[]) {

        if(args.length != 2) {
            System.out.println("Incorrect count of parameters. Please enter fileName and substring as parameters!");
            System.exit(1);
        }

        String fileName = args[0];
        String subString = args[1];

        if (Files.notExists(Paths.get(fileName))) {
            System.out.println("There is no file with name " + fileName);
        } else {
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

                stream
                        .filter(line -> line.contains(subString))
                        .forEach(System.out::println);

            } catch (IOException e) {
                throw new RuntimeException("Unbelievable error while reading the file " + fileName +"\n", e);
            }


        }
    }
}