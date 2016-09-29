package util;

import enums.GrepParamNameEnum;

/**     -b	Предваряет каждую строку номером блока, в котором она была найдена.
*           Это может пригодиться при поиске блоков по контексту (блоки нумеруются с 0).
*       -c	Выдает только количество строк, содержащих образец.
*       -h	Предотвращает выдачу имени файла, содержащего сопоставившуюся строку,
*           перед собственно строкой. Используется при поиске по нескольким файлам.
*       -i	Игнорирует регистр символов при сравнениях.
*       -l	Выдает только имена файлов, содержащих сопоставившиеся строки, по одному в строке.
*           Если образец найден в нескольких строках файла, имя файла не повторяется.
*       -n	Выдает перед каждой строкой ее номер в файле (строки нумеруются с 1).
*       -s	Подавляет выдачу сообщений о не существующих или недоступных для чтения файлах.
*       -v	Выдает все строки, за исключением содержащих образец.
*       -w	Ищет выражение как слово, как если бы оно было окружено метасимволами \< и \>.
*/

public class GrepRuntimeConfigurator {

    private String[] commandLineParams;
    private String fileName;
    private String searchPattern;
    private boolean existParams = false;
    private boolean isCFlagSet = false;
    private boolean isHFlagSet = false;
    private boolean isIFlagSet = false;
    private boolean isLFlagSet = false;
    private boolean isNFlagSet = false;
    private boolean isSFlagSet = false;
    private boolean isVFlagSet = false;
    private boolean isWFlagSet = false;


    public GrepRuntimeConfigurator( String[] args ) {

        setCommandLineParams(args);

        GrepValidator validator = new GrepValidator();
        if ( !validator.isValidCommandLineArgs( args ) ) {
            System.err.println( "Exit program." );
            return;
        }

        parseParameters( args );
    }

    private void parseParameters(String[] params) {

        int len = params.length;
        setFileName( params[len - 1] );
        setSearchPattern( params[len - 2] );

        if ( params.length  > 3 ) {
            existParams = true;
            setParams( params );
        }
    }

    public void setParams(String[] params) {

        for ( int i = 1; i < params.length - 2; i++) {
            if ( GrepParamNameEnum.contains( params[i] ) ) {
                setParam( params[i] );
            }
        }
    }

    public void setParam(String param) {
        if ( GrepParamNameEnum.LC_C_PARAM.equals( param ) ) {
            isCFlagSet = true;
        } else  if ( GrepParamNameEnum.LC_H_PARAM.equals( param ) ) {
            isHFlagSet = true;
        } else  if ( GrepParamNameEnum.LC_I_PARAM.equals( param ) ) {
            isIFlagSet = true;
        } else  if ( GrepParamNameEnum.LC_L_PARAM.equals( param ) ) {
            isLFlagSet = true;
        } else  if ( GrepParamNameEnum.LC_N_PARAM.equals( param ) ) {
            isNFlagSet = true;
        } else  if ( GrepParamNameEnum.LC_S_PARAM.equals( param ) ) {
            isSFlagSet = true;
        } else  if ( GrepParamNameEnum.LC_V_PARAM.equals( param ) ) {
            isVFlagSet = true;
        } else  if ( GrepParamNameEnum.LC_W_PARAM.equals( param ) ) {
            isWFlagSet = true;
        }
    }

    public void setCommandLineParams( String[] commandLineParams ) {
        this.commandLineParams = commandLineParams;
    }

    public String getFilename() {
        return this.fileName;
    }

    public  void setFileName( String fileName) {
        this.fileName = fileName;
    }

    public String getSearchPattern() {
        return this.searchPattern;
    }

    public void setSearchPattern( String pattern ) {
        this.searchPattern = pattern;
    }

    public boolean isIFlagSet() {
        return isIFlagSet;
    }

    public void setIFlagSet(boolean flag) {
        isIFlagSet = flag;
    }

    public boolean isExistParams() {
        return existParams;
    }

    public void setExistParams(boolean existParams) {
        this.existParams = existParams;
    }
}



