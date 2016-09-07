import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParamsGrep {

    public void grep(String param,
                     String pattern,
                     String fileName
    ) {
        Path file = Paths.get( fileName );

        if ( !Files.exists( file ) ) {
            System.out.println( "File not found.");
            return;
        }

        if ( "-i".equals( param ) ) {
            iParamGrep( pattern, file );

        } else if ( "-r".equals( param ) ) {
            rParamGrep( pattern, file );

        } else if ( "-v".equals( param ) ) {
            vParamGrep( pattern, file );

        } else  if ( "-l".equals( param ) ) {
            lParamGrep( pattern, file );
        }

    }

    private void iParamGrep(String pattern, Path file) {
        try {

            InputStream in = Files.newInputStream( file );
            BufferedReader reader =
                    new BufferedReader( new InputStreamReader( in ) );
            String line = null;
            int count = 0;

            while ((line = reader.readLine( ) ) != null ) {

                if ( line.toUpperCase().contains( pattern.toUpperCase() ) ) {
                    System.out.println(line);
                    count++;
                }
            }

            if ( count == 0 ) {
                System.out.println("Matches not found int file " + file + " .");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    private void rParamGrep(String pattern, Path file) {
    }

    private void lParamGrep(String pattern, Path file) {
    }

    private void vParamGrep(String pattern, Path file) {
    }
}
