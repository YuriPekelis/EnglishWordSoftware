package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Yuric on 10.05.2017.
 */
public class WarningWindowBeforeExit {
//extends JFrame {
//    private JButton okButton;
//    private JButton cancelButton;
//
//    private ClickedOKListener clickedOKListener;
//    private ClickedCancelListener clickedCancelListener;
//    private ThisWindowListener thisWindowListener;
//
//    private JFrame activeWindowBeforeThis;
//
//    public WarningWindowBeforeExit(JFrame window) {
//        activeWindowBeforeThis = window;
//        activeWindowBeforeThis.setVisible(false);
//
//        setTitle("Do you really want to quit?");
//        setBounds(200,200, 200,200);
//        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Container contentPane = getContentPane();
//        contentPane.setLayout(new BorderLayout());
//        contentPane.setBackground(Color.DARK_GRAY );
//
//        JLabel warningLabel = new JLabel("Do you really want to quit? All changes will be erased.");
//        warningLabel.setForeground(Color.WHITE);
//        contentPane.add(warningLabel);
//
//        JPanel buttonsPanel = new JPanel(new FlowLayout());
//        buttonsPanel.setBackground(Color.DARK_GRAY);
//        okButton = new JButton("OK");
//        cancelButton = new JButton("Cancel");
//        buttonsPanel.add(okButton);
//        buttonsPanel.add(cancelButton);
//        contentPane.add(buttonsPanel);
//        clickedOKListener = new ClickedOKListener ();
//        clickedCancelListener = new ClickedCancelListener();
//        thisWindowListener = new ThisWindowListener();
//        okButton.addActionListener(clickedOKListener);
//        cancelButton.addActionListener(clickedCancelListener);
//        this.addWindowListener(thisWindowListener);
//    }
//
//    private void closeListeners () {
//        okButton.removeActionListener(clickedOKListener);
//        cancelButton.removeActionListener(clickedCancelListener);
//        this.removeWindowListener(thisWindowListener);
//    }
//
//    private void dontExit () {
//        closeListeners();
//        activeWindowBeforeThis.setVisible(true);
//        this.dispose();
//    }
//
//    private class ClickedOKListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.exit(0);
//        }
//    }
//
//    private class ClickedCancelListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            dontExit();
//        }
//    }
//
//    private class ThisWindowListener implements WindowListener{
//        @Override
//        public void windowOpened(WindowEvent e) {
//
//        }
//
//        @Override
//        public void windowClosing(WindowEvent e) {
//            dontExit();
//        }
//
//        @Override
//        public void windowClosed(WindowEvent e) {
//
//        }
//
//        @Override
//        public void windowIconified(WindowEvent e) {
//
//        }
//
//        @Override
//        public void windowDeiconified(WindowEvent e) {
//
//        }
//
//        @Override
//        public void windowActivated(WindowEvent e) {
//
//        }
//
//        @Override
//        public void windowDeactivated(WindowEvent e) {
//
//        }
//    }
    public WarningWindowBeforeExit (WindowEvent e) {

        Object[] options = {"Да", "Нет!"};
        int n = JOptionPane
                .showOptionDialog(e.getWindow(), "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
        if (n == 0) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }
}
