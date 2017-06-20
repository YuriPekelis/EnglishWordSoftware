package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// critical error window
public class ErrorWindow extends JFrame{
    private static ArrayList <JFrame> windows = new ArrayList<>();

    public ErrorWindow(String errorMessage) {
        for (JFrame currentWindows: windows) {
            currentWindows.setVisible(false);
        }
        setTitle("Error");
        setBounds(200,200, 200,200);
        //setLocation(200, 200);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        //contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBackground( Color.DARK_GRAY );
        errorMessage ="<html><center> " + errorMessage + " \nPress OK to close the program. All changes will be erased. </center></html> ";
        JLabel errorLabel = new JLabel(errorMessage);
        errorLabel.setForeground(Color.WHITE);
        JButton okButton = new JButton("OK");
        contentPane.add(errorLabel, BorderLayout.CENTER);
        contentPane.add(okButton, BorderLayout.SOUTH);
        setVisible(true);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }


    public static void addWindow(JFrame window) {
        windows.add(window);
    }
}
