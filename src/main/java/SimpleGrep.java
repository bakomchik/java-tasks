import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleGrep {

    public void grep(String pattern,
                     String fileName
    ) {
        Path file = Paths.get( fileName );
        try {

            if ( !Files.exists( file ) ) {
                System.out.println( "File not found.");
                return;
            }

            InputStream in = Files.newInputStream( file );
            BufferedReader reader =
                    new BufferedReader( new InputStreamReader( in ) );
            String line = null;
            int count = 0;

            while ((line = reader.readLine( ) ) != null ) {

                if ( line.contains( pattern ) ) {
                    System.out.println(line);
                }
            }

            if (count == 0 ) {
                System.out.println("Matches not found int file " + file + " .");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
