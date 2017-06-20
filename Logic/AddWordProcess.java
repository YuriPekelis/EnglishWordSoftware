package Logic;

import Windows.AddWordWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddWordProcess {
    Libraries libraries;
    AddWordWindow addWordWindow;

    //Constructor receives wordlibraries and created window for adding words
    public AddWordProcess(Libraries libraries, AddWordWindow window) {
        this.libraries = libraries;
        this.addWordWindow = window;
    }

    public void runAddWords() {
        addWordWindow.runAdding(Const.ADD_WORD_MESSAGE_FILL);;
        addWordWindow.getAddWordButton().addActionListener(new AddWordButtonClicked());
    }

    public class AddWordButtonClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!addWordWindow.getWord().isEmpty() && !addWordWindow.getTranslation().isEmpty()) {
                String flagOfSwappingWords;
                if (addWordWindow.getSwapWordAndTranslationCheckbox().isSelected())
                    flagOfSwappingWords = "1";
                else {
                    if (addWordWindow.getReverseWordAndTranslationCheckbox().isSelected())
                        flagOfSwappingWords = "2";
                    else
                        flagOfSwappingWords = "0";
                }
                libraries.addNewWord(addWordWindow.getWord(), addWordWindow.getTranslation(), flagOfSwappingWords);
                addWordWindow.runAdding(Const.ADD_WORD_MESSAGE_ADDED);
            }
            else
                addWordWindow.runAdding(Const.ADD_WORD_MESSAGE_ERROR);
        }
    }
}
