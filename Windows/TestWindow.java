package Windows;

import Logic.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
The window for testing knowledge
 */
public class TestWindow extends JFrame {
    private Container contentPane = getContentPane(); //container for elements

    //panel for radio butons for choosing library for test (unknown or known)
    private  JPanel choiceLibraryPanel = new JPanel();
    private  JRadioButton testUnknownWordsRButton = new JRadioButton(Const.UNKNOWN_WORDS);
    private  JRadioButton testKnownWordsRButton = new JRadioButton(Const.KNOWN_WORDS);
    private  ButtonGroup choiceLibrary = new ButtonGroup();

    //the panel with question. Also it is used to show message that there is no any word in a library
    private JPanel testingWordPanel = new JPanel();
    private JTextArea testingWordArea = new JTextArea("");

    //the button for showing answer
    private JPanel showButtonPanel= new JPanel();
    private JButton showButton = new JButton("Show Answer");

    //the panel with right answer to check
    private JPanel rightAnswerPanel  = new JPanel();
    private JTextArea rightAnswerArea = new JTextArea("");

    //the panel with two option. User chooses if he/she knows this word. Only in the unknown words test mode
    private JPanel knowButtonsPanel  = new JPanel();
    private JButton iKnowitButton = new JButton("I know this word");
    private JButton iDontKnowItButton = new JButton("I don't know this word");

    //the panel with two option. User chooses if he/she wants to see the next word or to see it after moving the current
    // word to unknown words library. Only in the known words test mode
    private JPanel nextWordPanelOnTestKnownWords;
    private JButton wordForgotten = new JButton("I forgot this word");
    private JButton nextWordButtonOnTestKnownWords = new JButton ("Next word");

    //the panel with back to main menu button
    private JPanel backToMainMenuPanel = new JPanel();
    private  JButton backToMainMenuButton = new JButton("Back to Main Menu");

    //right answer for current word
    String currentTranslation;

    public TestWindow () {
        setTitle("Testing Word Knowledge");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBounds(200, 200, 400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        setBackroundForObject(choiceLibraryPanel);
        choiceLibraryPanel.setLayout(new FlowLayout());
        choiceLibrary.add(testUnknownWordsRButton);
        testUnknownWordsRButton.setSelected(true);
        choiceLibrary.add(testKnownWordsRButton);
        setBackroundForObject(testKnownWordsRButton);
        testUnknownWordsRButton.setForeground(Color.WHITE);
        setBackroundForObject(testUnknownWordsRButton);
        testKnownWordsRButton.setForeground(Color.WHITE);
        choiceLibraryPanel.add(testUnknownWordsRButton);
        choiceLibraryPanel.add(testKnownWordsRButton);
        contentPane.add(choiceLibraryPanel);

        testingWordArea.setForeground(Color.WHITE);
        setBackroundForObject(testingWordArea);
        testingWordArea.setEnabled(false);
        testingWordPanel.add(testingWordArea);
        setBackroundForObject(testingWordPanel);
        contentPane.add(testingWordPanel);

        showButtonPanel.add(showButton);
        setBackroundForObject(showButtonPanel);
        contentPane.add(showButtonPanel);

        setBackroundForObject(rightAnswerArea);
        rightAnswerArea.setForeground(Color.WHITE);
        rightAnswerArea.setEnabled(false);
        rightAnswerPanel.add(rightAnswerArea);
        setBackroundForObject(rightAnswerPanel);
        contentPane.add(rightAnswerPanel);

        knowButtonsPanel.add(iKnowitButton);
        knowButtonsPanel.add(iDontKnowItButton);
        setBackroundForObject(knowButtonsPanel);
        contentPane.add(knowButtonsPanel);

        nextWordPanelOnTestKnownWords = new JPanel();
        setBackroundForObject(nextWordPanelOnTestKnownWords);
        nextWordPanelOnTestKnownWords.add(wordForgotten);
        nextWordPanelOnTestKnownWords.add(nextWordButtonOnTestKnownWords);
        contentPane.add(nextWordPanelOnTestKnownWords);
        nextWordPanelOnTestKnownWords.setVisible(false);

        backToMainMenuPanel.add(backToMainMenuButton);
        setBackroundForObject(backToMainMenuPanel);
        contentPane.add(backToMainMenuPanel);
        setVisible(false);


        ErrorWindow.addWindow(this);
    }

    //returns button for listeners in other classes
    public JButton getBackToMainMenuButton() {
        return backToMainMenuButton;
    }
    public JButton getWordForgotten() {
        return wordForgotten;
    }
    public JButton getIDontKnowItButton() {
        return iDontKnowItButton;
    }
    public JButton getIKnowItButton() {
        return iKnowitButton;
    }
    public JButton getNextWordButtonOnTestKnownWords() {
        return nextWordButtonOnTestKnownWords;
    }
    public JRadioButton getTestKnownWordsRButton() {
        return testKnownWordsRButton;
    }
    public JRadioButton getTestUnknownWordsRButton() {
        return testUnknownWordsRButton;
    }

    //change windows to show that there is nothing in a library
    public void noWords() {
        testingWordArea.setText(Const.NO_WORDS);
        testingWordPanel.setVisible(true);
        showButton.setEnabled(false);
        rightAnswerArea.setText("");
        if (testKnownWordsRButton.isSelected())
            nextWordButtonOnTestKnownWords.setEnabled(false);
        if (testUnknownWordsRButton.isSelected()) {
            iDontKnowItButton.setEnabled(false);
            iKnowitButton.setEnabled(false);
        }
    }

    //changes with elements to show unknown/known test window
    public void runKnownWordTesting() {
        testingWordArea.setVisible(true);
        testingWordPanel.setVisible(true);
        showButton.setEnabled(true);
        rightAnswerArea.setText("");
        knowButtonsPanel.setVisible(false);
        nextWordPanelOnTestKnownWords.setVisible(true);
        nextWordButtonOnTestKnownWords.setEnabled(false);
        wordForgotten.setEnabled(false);
        showButton.addActionListener(new ClickedShowButton());
    }
    public void runUnknownWordTesting() {
        testingWordPanel.setVisible(true);
        showButton.setEnabled(true);
        rightAnswerArea.setText("");
        knowButtonsPanel.setVisible(true);
        iKnowitButton.setEnabled(false);
        iDontKnowItButton.setEnabled(false);
        nextWordPanelOnTestKnownWords.setVisible(false);
        backToMainMenuPanel.setVisible(true);
        showButton.addActionListener(new ClickedShowButton());
        setVisible(true);
    }

    //set background color for the object
    public void setBackroundForObject (JComponent currentObject) {
        currentObject.setBackground(Color.DARK_GRAY);
    }

    //set text for elements from chosen words
    public void setWordAndTranslation (String word, String translate) {
        currentTranslation = translate;
        testingWordArea.setText(word);

    }

    //listener for a button to show the right answer
    public class ClickedShowButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            showButton.setEnabled(false);
            rightAnswerArea.setText(currentTranslation);
            if (testKnownWordsRButton.isSelected()) {
                wordForgotten.setEnabled(true);
                nextWordButtonOnTestKnownWords.setEnabled(true);
            }
            if (testUnknownWordsRButton.isSelected()) {
                iDontKnowItButton.setEnabled(true);
                iKnowitButton.setEnabled(true);
            }
        }
    }
}
