import grepper.Grepper;
import grepper.ParamGrepperImpl;
import grepper.SimpleGrepper;
import util.GrepRuntimeConfigurator;

public class Main {

    public static void main( String[] args ) {

        GrepRuntimeConfigurator config = new GrepRuntimeConfigurator( args );

        if ( config.isExistParams() ) {
            Grepper g = new ParamGrepperImpl();
            g.grep( config );
        } else {
            Grepper g = new SimpleGrepper();
            g.grep( config );
        }

    }
}
