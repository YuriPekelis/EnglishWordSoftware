package Logic;

import java.util.ArrayList;

/**
 * Created by Yuric on 01.05.2017.
 */
public class Libraries {
    ArrayList <UnknownWord> unknownLibrary = new ArrayList<>(); //Array for unknown words
    ArrayList <KnownWord> knownLibrary = new ArrayList<>(); // Array for know words

    //creates arrays after loading software from saved files
    public Libraries(Files files) {
        while (files.getUnknownWordsScanner().hasNextLine()) {
            unknownLibrary.add(new UnknownWord (files.getUnknownWordsScanner().nextLine().split(Const.SEPARATOR_IN_FILE)));
        }
        files.getUnknownWordsScanner().close();

        while (files.getKnownWordsScanner().hasNextLine()) {
            knownLibrary.add(new KnownWord(files.getKnownWordsScanner().nextLine().split(Const.SEPARATOR_IN_FILE)));
        }
        files.getKnownWordsScanner().close();
    }

    public int getSizeUnknownLibrary () {
        return unknownLibrary.size();
    }

    public int getSizeKnownLibrary (){
        return knownLibrary.size();
    }

    //adding new word to the unknown word library
    public void addNewWord (String word, String translation, String swapWordAndTranslation) {
        String [] line = {word, translation, String.valueOf(Const.NUMBER_OF_TRIES_TO_LEARN), swapWordAndTranslation};
        unknownLibrary.add(new UnknownWord(line));
    }

    //moving from unknown to known library
    public void wordLearned (int number) {
        String [] line = {unknownLibrary.get(number).getWord(), unknownLibrary.get(number).getTranslation()
                , Integer.toString(unknownLibrary.get(number).getSwapWordAndTranslation())};
        knownLibrary.add(new KnownWord(line));
        unknownLibrary.remove(number);

    }
    //moving from known to unknown library. User doesn`t remember learned before word.
    public void forgetWord(int numberInArray) {
        addNewWord(knownLibrary.get(numberInArray).getWord(), knownLibrary.get(numberInArray).getTranslation()
                ,Integer.toString(knownLibrary.get(numberInArray).getSwapWordAndTranslation()));
        knownLibrary.remove(numberInArray);
    }

    //returns from libraries word with specific number
    public UnknownWord getUnknownWordByNumber (int number) {
        return unknownLibrary.get(number);
    }
    public KnownWord getKnownWordByNumber (int number) {
        return knownLibrary.get(number);
    }

}
