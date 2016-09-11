package grepper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleGrepperImpl implements Grepper {

    public void grep( String[] params ) {

        int len = params.length;
        String pattern = params[len - 2];
        String fileName = params[len - 1];

        Path file = Paths.get( fileName );

        try {
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
