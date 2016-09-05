import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    public static void main( String[] args ) {

        String command = null;
        String substring = null;
        String fileName = null;

        if ( args.length  == 3 ) {
            command = args[0];
            substring = args[1];
            fileName = args[2];
        } else {
            System.out.println( "Three arguments are expected." );
            return;
        }

        if ( !"grep".equals( command ) ) {
            System.out.println( "Only grep command allowed." );
            return;
        }

        Path file = Paths.get( fileName );
        try {
            InputStream in = Files.newInputStream( file );
            BufferedReader reader =
                    new BufferedReader( new InputStreamReader( in ) );
            String line = null;

            while ((line = reader.readLine( ) ) != null ) {

                if ( line.contains( substring ) ) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            e.printStackTrace();
        }
    }
}
