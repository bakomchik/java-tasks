package enums;

public enum GrepParamNameEnum {
    LC_C_PARAM( "-c" ),
    LC_H_PARAM( "-h" ),
    LC_I_PARAM( "-i" ),
    LC_L_PARAM( "-l" ),
    LC_N_PARAM( "-n" ),
    LC_S_PARAM( "-s" ),
    LC_V_PARAM( "-v" ),
    LC_W_PARAM( "-w" )
    ;

    private final String text;

    private GrepParamNameEnum( final String text ) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }

    public static boolean contains( String test ) {

        for ( GrepParamNameEnum c : GrepParamNameEnum.values() ) {
            if ( c.toString().equals( test ) ) {
                return true;
            }
        }

        return false;
    }
}
