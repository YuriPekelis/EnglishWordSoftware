package Logic;

import Windows.ErrorWindow;

//describes structure of words in known words library.
public class KnownWord extends Element{

    public KnownWord(String[] line) {
        //control for input data
        if (line.length != Const.NUMBER_WORD_PARAMETERS)
            new ErrorWindow(Const.ERROR_FILE_STRUCTURE);
        try {
            swapWordAndTranslation = Integer.parseInt(line[2]);
        } catch (NumberFormatException e) {
            new ErrorWindow(Const.ERROR_FILE_STRUCTURE);
        }
        word = line[0];
        translation = line[1];
    }

}
