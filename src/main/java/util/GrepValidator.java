package util;

import enums.GrepParamNameEnum;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GrepValidator {

    public boolean isValidCommandLineArgs(String[] params ) {

        if ( !existParams( params ) ) {
            System.out.println( "Error. Command line parameters are expected." );
            return false;
        }

        String command = params[0];
        if ( !isGrepCommand( command ) ) {
            System.out.println( "Error. Only /'grep/' command is allowed." );
            return false;
        }

        return isValidParams( params );
    }

    private boolean isValidParams(String[] params) {

        if ( !isValidLength( params ) ) {
            System.out.println( "Error. Three or four arguments are expected." );
            return false;
        }

        int len = params.length;
        String fileName = params[len - 1];
        Path file = Paths.get( fileName );

        if ( !isExistFile( file ) ) {
            System.out.println( "Error. File " + fileName + " not found." );
            return false;
        }

        if ( !isValidGrepParams( params ) ) {
            System.out.println( "Error. Grep parameters is not valid." );
            return false;
        }

        return true;
    }

    private boolean isValidGrepParams(String[] params) {

        if ( params.length < 4 ) {
            return true;
        }

        int len = params.length;

        for ( int i = 1; i < len - 2; i++ ) {
            if ( !GrepParamNameEnum.contains( params[i] ) ) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidLength(String[] params) {
        return params.length  > 2;
    }

    private boolean isExistFile( Path file ) {
        return Files.exists( file );
    }

    private boolean isGrepCommand(String command) {
        return "grep".equals( command );
    }

    private boolean existParams(String[] params) {
        return params.length != 0;
    }




}
