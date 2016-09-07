package fesd.Grep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by denis.kostin on 05/09/16.
 */

public class SimpleGrep {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Arguments are not specified!\nUsage: java -jar SimpleGrep <regexp> <filename>");
            System.exit(1);
        }

        String regexp = args[0];
        String fileName = args[1];
        Path path = Paths.get(fileName);

        if (!Files.exists(path)) {
            System.out.println("File does not exist: "+path.toAbsolutePath());
            System.exit(1);
        }

        try {
            Files.lines(path).filter(line -> line.contains(regexp)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Something wrong");
        }
    }
}
