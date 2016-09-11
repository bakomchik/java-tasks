import grepper.Grepper;
import grepper.ParamGrepperImpl;
import grepper.SimpleGrepperImpl;
import util.GrepValidator;

import java.nio.file.Files;

public class Main {

    public static void main( String[] args ) {

        GrepValidator validator = new GrepValidator();

        if ( !validator.isValid( args ) ) {
            System.err.println("Exit program.");
            return;
        }

        if ( args.length  > 3 ) {
            paramGrep( args );
        } else {
            noParamsGrep( args );
        }
    }

    private static void noParamsGrep(String[] args) {
        Grepper g = new SimpleGrepperImpl();
        g.grep(args);
    }

    private static void paramGrep(String[] args) {
        Grepper g = new ParamGrepperImpl();
        g.grep(args);
    }
}
