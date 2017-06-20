package Windows;

import Logic.Libraries;

import javax.swing.*;
import java.awt.*;

/**
Creates Main window and elements. Exist control for disabling test button when there are no words in the libraries
 */
public class MainWindow extends JFrame {
    private JButton addButton;
    private JButton testButton;
    private JButton exitButton;
    private Libraries libraries;

    public MainWindow(Libraries libraries) {
        this.libraries = libraries;
        setTitle("Learning your words");
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        Container contentPane = getContentPane();
        contentPane.setBackground( Color.DARK_GRAY );
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel actionButtonPanel = new JPanel(new FlowLayout());
        actionButtonPanel.setBackground(Color.DARK_GRAY);
            addButton = new JButton("Add Words");
            actionButtonPanel.add(addButton);

            testButton = new JButton("Test your knowledge");
            actionButtonPanel.add(testButton);
        contentPane.add(actionButtonPanel);

        exitButton = new JButton("Exit");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPane.add(exitButton);
        setMainFrameVisible();
        pack();
        ErrorWindow.addWindow(this);
    }

    public void setMainFrameVisible () {
        if (libraries.getSizeUnknownLibrary() == 0 && libraries.getSizeKnownLibrary() == 0)
            testButton.setEnabled(false);
        else
            testButton.setEnabled(true);
        setVisible(true);
    }

    // returning button for listening for other classes
    public JButton getAddButton() {
        return addButton;
    }
    public JButton getExitButton() {
        return exitButton;
    }
    public JButton getTestButton() {
        return testButton;
    }

}
