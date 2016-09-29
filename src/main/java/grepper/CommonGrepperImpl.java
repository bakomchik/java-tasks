package grepper;

import util.GrepRuntimeConfigurator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class CommonGrepperImpl implements Grepper {

    public void grep( GrepRuntimeConfigurator config ) {
        String pattern = config.getSearchPattern();
        Path file = Paths.get( config.getFilename() );

        try {
            InputStream in = Files.newInputStream( file );
            BufferedReader reader =
                    new BufferedReader( new InputStreamReader( in ) );
            String line = null;
            int count = 0;

            while ((line = reader.readLine( ) ) != null ) {

                if ( contains (line, pattern) ) {
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

    abstract public boolean contains ( String line, String pattern );
}
