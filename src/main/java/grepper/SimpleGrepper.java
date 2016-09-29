package grepper;

import util.GrepRuntimeConfigurator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleGrepper extends CommonGrepperImpl {

    public boolean contains ( String line, String pattern ) {
        return line.contains( pattern );
    }
}
