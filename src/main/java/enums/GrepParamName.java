package enums;

import java.awt.*;

public enum GrepParamName {
    LC_I_PARAM("-i"),
    LC_R_PARAM("-r"),
    LC_V_PARAM("-v"),
    LC_L_PARAM("-l")
    ;

    private final String text;

    private GrepParamName(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }

    public static boolean contains(String test) {

        for (GrepParamName c : GrepParamName.values()) {
            if (c.toString().equals(test)) {
                return true;
            }
        }

        return false;
    }
}
