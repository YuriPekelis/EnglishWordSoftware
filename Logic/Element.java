package Logic;

/**
 * Created by Yuric on 15.05.2017.
 */
public class Element {
    protected String word;
    protected String translation;
    protected int swapWordAndTranslation;
    //values 0 - standard order word - is shown, translation for checking, 2 - reverse order, 1 - random order

    public String getWord() {
        return word;
    }
    public String getTranslation() {
        return translation;
    }
    public int getSwapWordAndTranslation() {
        return swapWordAndTranslation;
    }

}
