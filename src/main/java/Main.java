import grepper.Grepper;
import grepper.ParamGrepperImpl;
import grepper.SimpleGrepperImpl;
import util.GrepRuntimeConfigurator;
import util.GrepValidator;

import java.nio.file.Files;

public class Main {

    public static void main( String[] args ) {

        GrepRuntimeConfigurator config = new GrepRuntimeConfigurator( args );


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
