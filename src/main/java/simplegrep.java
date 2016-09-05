import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by denis.kostin on 05/09/16.
 */

public class simplegrep {
    public static void main(String[] args) {
        final String regexp = args[0];
        String fileName = args[1];
        Path path = Paths.get(fileName);

        try {
            Files.lines(path).filter(line -> line.contains(regexp)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
