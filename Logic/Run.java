package Logic;

import Windows.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Yuric on 01.05.2017.
 */
public class Run {
    private static Files files;  //class with files to create scanners and
    private static Libraries libraries; //arrays with unknown and known words
    private static MainWindow mainWindow; //main window of the program (JFrame)
    private static AddWordWindow addWordWindow; // this window for adding words
    private static TestWindow testWindow; //this window for testing knowledge
    private static AddWordProcess addWordProcess; //logic process of adding
    private static TestProcess testProcess; //logic for testing knowledge


    public static void main (String [] args) {
        //open files
        files = new Files();
        //create arrays with words
        libraries = new Libraries(files);

        //creating new Windows
        mainWindow = new MainWindow(libraries);
        addWordWindow = new AddWordWindow();
        testWindow = new TestWindow();

        //creating for process test and addWord
        addWordProcess = new AddWordProcess(libraries, addWordWindow);
        testProcess = new TestProcess (libraries,testWindow);

//        Listening buttons on main menu (Add Word, Test knowledge and exit) and return to main menu
//        buttons on other windows
        mainWindow.getTestButton().addActionListener(new ClickedTestButtonOnMainPage ());
        mainWindow.getAddButton().addActionListener(new ClickedAddButtonOnMainPage());
        mainWindow.getExitButton().addActionListener(new ClickedExitButton());
        addWordWindow.getReturnMainMenuButton().addActionListener(new ClickedReturnButtonOnAddWordMenu());
        testWindow.getBackToMainMenuButton().addActionListener(new ClickedReturnButtonOnTestWindow ());
        mainWindow.addWindowListener(new ClickedCloseWindow ());
        addWordWindow.addWindowListener(new ClickedCloseWindow ());
        testWindow.addWindowListener(new ClickedCloseWindow());
        }
    private static class ClickedTestButtonOnMainPage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainWindow.setVisible(false);
            testProcess.runTestUnknownWords ();
        }
    }
    private static class ClickedAddButtonOnMainPage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainWindow.setVisible(false);
            addWordProcess.runAddWords();
        }
    }
    private static class ClickedExitButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            files.exitFiles(libraries);
        }
    }
    private static class ClickedReturnButtonOnAddWordMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addWordWindow.setVisible(false);
            mainWindow.setMainFrameVisible();
        }
    }
    private static class ClickedReturnButtonOnTestWindow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            testWindow.setVisible(false);
            testProcess.backToMainMenu();
            mainWindow.setMainFrameVisible();
        }
    }
    private static class ClickedCloseWindow implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            new WarningWindowBeforeExit(e);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
