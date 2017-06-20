package Logic;

import Windows.TestWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TestProcess {
    private Libraries libraries;
    private TestWindow testWindow;
    private int numberInArray; //current chosen word in library

    private static String currentWord; //question for current word
    private static String currentTranslation; //answer for current word

    //Button`s listener on this page
    private ClickedForgetWordButton clickedForgetWordButton;
    private ClickedIKnowItButton clickedIKnowItButton;
    private ClickedIdontKnowButton clickedIdontKnowButton;
    private ChosenKnownWordRadioButton chosenKnownWordRadioButton;
    private ChosenUnknownWordRadioButton chosenUnknownWordRadioButton;
    private ChosenNextWordKnownWordsTest chosenNextWordKnownWordsTest;

    //Constructor recieves wordlibraries and created window for testing knowledge
    public TestProcess(Libraries libraries, TestWindow window) {
        this.libraries = libraries;
        this.testWindow = window;
    }

    //first run of the process for testing unknown words knowledge  (creates also listeners for buttons with
    // internal-window action) and repeated run (also control of not zero number of words)
    public void runTestUnknownWords() {
        testUnknownWordAgain();
        clickedIKnowItButton = new ClickedIKnowItButton();
        clickedIdontKnowButton = new ClickedIdontKnowButton ();
        chosenKnownWordRadioButton = new ChosenKnownWordRadioButton();
        testWindow.getIKnowItButton().addActionListener(clickedIKnowItButton);
        testWindow.getIDontKnowItButton().addActionListener(clickedIdontKnowButton);
        testWindow.getTestKnownWordsRButton().addActionListener(chosenKnownWordRadioButton);
    }
    private void testUnknownWordAgain () {
        testWindow.runUnknownWordTesting();
        if (libraries.getSizeUnknownLibrary() != 0) {
            testWindow.setVisible(true);
            numberInArray = (int) (Math.random()*libraries.getSizeUnknownLibrary());
            System.out.println(numberInArray);
            currentWord = libraries.getUnknownWordByNumber(numberInArray).getWord();
            currentTranslation = libraries.getUnknownWordByNumber(numberInArray).getTranslation();
            switch (libraries.getUnknownWordByNumber(numberInArray).getSwapWordAndTranslation()) {
                case 0:
                    testWindow.setWordAndTranslation(currentWord, currentTranslation);
                    break;
                case 2:
                    testWindow.setWordAndTranslation(currentTranslation, currentWord);
                    break;
                default:
                    if ((int)(2*Math.random()) == 0)
                        testWindow.setWordAndTranslation(currentWord, currentTranslation);
                    else
                        testWindow.setWordAndTranslation(currentTranslation, currentWord);
                    break;
            }
        }
        else {
            testWindow.noWords ();
        }
    }

    //first run of the process for testing known words knowledge  (creates also listeners for buttons with
    // internal-window action) and repeated run (also control of not zero number of words)
    private void testKnownWordAgain () {
        testWindow.runKnownWordTesting();
        if (libraries.getSizeKnownLibrary() != 0) {
            numberInArray = (int) (Math.random()*libraries.getSizeKnownLibrary());
            //numberInArray = (random.nextInt()/libraries.getSizeKnownLibrary());
            currentWord = libraries.getKnownWordByNumber(numberInArray).getWord();
            currentTranslation = libraries.getKnownWordByNumber(numberInArray).getTranslation();
            System.out.println(libraries.getKnownWordByNumber(numberInArray).getSwapWordAndTranslation());
            switch (libraries.getKnownWordByNumber(numberInArray).getSwapWordAndTranslation()) {
                case 0:
                    testWindow.setWordAndTranslation(currentWord, currentTranslation);
                    break;
                case 2:
                    testWindow.setWordAndTranslation(currentTranslation, currentWord);
                    break;
                default:
                    if ((int)(2*Math.random()) == 0)
                        testWindow.setWordAndTranslation(currentWord, currentTranslation);
                    else
                        testWindow.setWordAndTranslation(currentTranslation, currentWord);
                    break;
            }
        }
        else {
            testWindow.noWords ();
        }
    }
    public void runTestKnownWords () {
        testKnownWordAgain();
        clickedForgetWordButton = new ClickedForgetWordButton ();
        chosenUnknownWordRadioButton = new ChosenUnknownWordRadioButton ();
        chosenNextWordKnownWordsTest = new ChosenNextWordKnownWordsTest ();
        testWindow.getTestUnknownWordsRButton().addActionListener(chosenUnknownWordRadioButton);
        testWindow.getNextWordButtonOnTestKnownWords().addActionListener(chosenNextWordKnownWordsTest);
        testWindow.getWordForgotten().addActionListener(clickedForgetWordButton);
    }

    //close ActionListener 1,2 - switch known-unknown words, 3 - exit to main menu
    private void closeIDontKnowListeners () {
        testWindow.getIDontKnowItButton().removeActionListener(clickedIdontKnowButton);
        testWindow.getTestKnownWordsRButton().removeActionListener(chosenKnownWordRadioButton);
        testWindow.getTestUnknownWordsRButton().removeActionListener(chosenUnknownWordRadioButton);

    }
    private void closeIKnowListener () {
        testWindow.getIKnowItButton().removeActionListener(clickedIKnowItButton);
        testWindow.getNextWordButtonOnTestKnownWords().removeActionListener(chosenNextWordKnownWordsTest);
        testWindow.getWordForgotten().removeActionListener(clickedForgetWordButton);
    }
    public void backToMainMenu() {
        closeIDontKnowListeners();
        closeIKnowListener();
    }

    private class ClickedIKnowItButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            libraries.getUnknownWordByNumber(numberInArray).goodTry();
            if (libraries.getUnknownWordByNumber(numberInArray).getTriesRemainToKnow() <= 0)
                libraries.wordLearned(numberInArray);
            testUnknownWordAgain();
        }
    }
    private class ClickedIdontKnowButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            libraries.getUnknownWordByNumber(numberInArray).badTry();
            testUnknownWordAgain();
        }
    }
    private class ChosenKnownWordRadioButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            closeIDontKnowListeners();
            runTestKnownWords();
        }
    }
    private class ChosenUnknownWordRadioButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            closeIKnowListener();
            runTestUnknownWords();
        }
    }
    private class ChosenNextWordKnownWordsTest implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            testKnownWordAgain();
        }
    }
    private class ClickedForgetWordButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            libraries.forgetWord (numberInArray);
            testKnownWordAgain();
        }
    }
}
