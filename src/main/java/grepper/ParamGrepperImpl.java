package grepper;

import util.GrepRuntimeConfigurator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParamGrepperImpl extends CommonGrepperImpl {

    public boolean contains ( String line, String pattern ) {
        return line.toUpperCase().contains( pattern.toUpperCase() );
    }

//    private void rParamGrep(String pattern, Path file) {
//        System.out.println("go grep with -r parameter");
//    }
//
//    private void lParamGrep(String pattern, Path file) {
//        System.out.println("go grep with -l parameter");
//    }
//
//    private void vParamGrep(String pattern, Path file) {
//        System.out.println("go grep with -v parameter");
//    }
}
