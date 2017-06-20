package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Yuric on 01.05.2017.
 */
public class AddWordWindow extends JFrame{

    private Container contentPane; //container for JElements

    //checkboxes for choosing order flag for testing words
    private JCheckBox swapWordAndTranslationCheckbox;
    private JCheckBox reverseWordAndTranslationCheckbox;

    //fields for entering data
    private JTextField wordField;
    private JTextField translationField;

    //buttons for adding word and returning to main menu
    private JButton addWordButton;
    private JButton returnMainMenuButton;

    //shows state of operation, word was added or error with data
    private JTextField stateField;

    //this window creates invisible but with added elements
    public AddWordWindow () {
        setTitle("Add New Words");
        setBounds(200, 200, 400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getLayeredPane().setBackground(Color.DARK_GRAY);
        
        contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        contentPane.setBackground(Color.DARK_GRAY);

        JPanel swapWordAndTranslationPanel = new JPanel(new FlowLayout());
        swapWordAndTranslationPanel.setBackground(Color.DARK_GRAY);
        swapWordAndTranslationCheckbox = new JCheckBox("Swap word and translation");
            swapWordAndTranslationCheckbox.setForeground(Color.WHITE);
            swapWordAndTranslationCheckbox.setBackground(Color.DARK_GRAY);
        swapWordAndTranslationPanel.add(swapWordAndTranslationCheckbox);
        reverseWordAndTranslationCheckbox = new JCheckBox("Reverse check");
            reverseWordAndTranslationCheckbox.setForeground(Color.WHITE);
            reverseWordAndTranslationCheckbox.setBackground(Color.DARK_GRAY);
        swapWordAndTranslationPanel.add(reverseWordAndTranslationCheckbox);
        contentPane.add(swapWordAndTranslationPanel);

        stateField = new JTextField();
        JPanel stateFieldPanel = new JPanel();
        stateFieldPanel.setBackground(Color.DARK_GRAY);
            stateField.setEnabled(false);
            stateField.setBackground(Color.DARK_GRAY);
            stateField.setForeground(Color.WHITE);
        stateFieldPanel.add(stateField);
        stateFieldPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(stateFieldPanel);

        JPanel wordPanel = new JPanel();
        wordPanel.setBackground(Color.DARK_GRAY);
            wordPanel.setLayout(new FlowLayout());
            JLabel addWordText = new JLabel("Enter New English Word");
                addWordText.setForeground(Color.WHITE);
            wordPanel.add(addWordText);
                wordField = new JTextField(20);
            wordPanel.add(wordField);
        wordPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        contentPane.add(wordPanel);

        JPanel translationPanel = new JPanel(new FlowLayout());
        translationPanel.setBackground(Color.DARK_GRAY);
            JLabel addTranslationText = new JLabel("Enter Translation");
                addTranslationText.setForeground(Color.WHITE);
            translationPanel.add(addTranslationText);
            translationField = new JTextField(20);
            translationPanel.add(translationField);
        translationPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        contentPane.add(translationPanel);

        JPanel addWordPanel = new JPanel();
        addWordPanel.setBackground(Color.DARK_GRAY);
            addWordButton = new JButton("Add Word");
            //addWordButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            addWordPanel.add(addWordButton);
            addWordPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        contentPane.add(addWordButton);

        JPanel returnPanel = new JPanel();
        returnPanel.setBackground(Color.DARK_GRAY);
            returnMainMenuButton = new JButton("Back to main menu");
            //returnMainMenuButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            returnPanel.add(returnMainMenuButton);
            returnPanel.setAlignmentX((JComponent.CENTER_ALIGNMENT));
        contentPane.add(returnMainMenuButton);
        pack();

        ErrorWindow.addWindow(this);
        setVisible(false);
        swapWordAndTranslationCheckbox.addActionListener(new SwappedCheckboxClicked());
    }
    //change elements when addwords process has started
    public void runAdding (String state) {
        reverseWordAndTranslationCheckbox.setEnabled(false);
        swapWordAndTranslationCheckbox.setSelected(true);
        stateField.setText(state);
        wordField.setText("");
        translationField.setText("");
        setVisible(true);
        pack();
        repaint();
    }

    //returns elements for listeners in other classes
    public JButton getAddWordButton() {
        return addWordButton;
    }
    public JButton getReturnMainMenuButton() {
        return returnMainMenuButton;
    }
    public JCheckBox getReverseWordAndTranslationCheckbox() {
        return reverseWordAndTranslationCheckbox;
    }
    public JCheckBox getSwapWordAndTranslationCheckbox() {
        return swapWordAndTranslationCheckbox;
    }
    public String getWord () {
        return wordField.getText();
    }
    public String getTranslation () {
        return translationField.getText();
    }

    //When random order is set, manual can`t be chosen
    private class SwappedCheckboxClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (swapWordAndTranslationCheckbox.isSelected()) {
                reverseWordAndTranslationCheckbox.setSelected(false);
                reverseWordAndTranslationCheckbox.setEnabled(false);
            }
            else {
                reverseWordAndTranslationCheckbox.setEnabled(true);
            }
        }
    }
}
