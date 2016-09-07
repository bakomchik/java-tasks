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
        String param = null;
        String substring = null;
        String fileName = null;

        if ( args.length == 0 ) {
            System.out.println( "No parameters." );
            return;
        }

        command = args[0];

        if ( !"grep".equals( command ) ) {
            System.out.println( "Only grep command allowed." );
            return;
        }

        if ( args.length  == 3 ) {
            noParamsGrep( args );
        } else  if ( args.length == 4 ){
            paramsGrep( args );
        } else {
            System.out.println( "Three or four arguments are expected." );
            return;
        }
    }

    private static void noParamsGrep(String[] args) {
        String substring = args[1];
        String fileName = args[2];

        SimpleGrep g = new SimpleGrep();
        g.grep(substring, fileName);
    }

    private static void paramsGrep(String[] args) {
        String param = args[1];
        String substring = args[2];
        String fileName = args[3];

        ParamsGrep g = new ParamsGrep();
        g.grep(param, substring, fileName);
    }
}
