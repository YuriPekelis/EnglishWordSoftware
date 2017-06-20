package Logic;

import Windows.ErrorWindow;
//describes structure of words in unknown words library.
public class UnknownWord extends Element{
    // remained number of tries for moving from unknown to known words library
    private int triesRemainLostToKnow;

    public UnknownWord(String[] line) {
        if (line.length != Const.NUMBER_WORD_PARAMETERS + 1)
            new ErrorWindow(Const.ERROR_FILE_STRUCTURE);
        try {
            triesRemainLostToKnow = Integer.parseInt(line[2]);
            swapWordAndTranslation = Integer.parseInt(line[3]);
        } catch (NumberFormatException e) {
            new ErrorWindow(Const.ERROR_FILE_STRUCTURE);
        }
        word = line[0];
        translation = line[1];
    }

    public int getTriesRemainToKnow() {
        return triesRemainLostToKnow;
    }

    //When user knows word
    public void goodTry () {
        triesRemainLostToKnow --;
    }
    //When user doesn't know word
    public void badTry () {
        triesRemainLostToKnow ++;
    }


}
