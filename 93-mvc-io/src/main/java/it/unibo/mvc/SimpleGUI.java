package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    /**
     * 
     * @param controller is used to handle the I/O interface
     */
    public SimpleGUI(final Controller controller) {
        frame.setName("Print your strings");
        final JPanel myPanel = new JPanel(new BorderLayout());
        final JPanel myButtonPanel = new JPanel(new BorderLayout());
        final JTextField myField = new JTextField();
        final JTextArea myArea = new JTextArea();
        final JButton myPrintButton = new JButton("Print");
        final JButton myShowHistoryButton = new JButton("Show history");
        myArea.setEditable(false);
        myPanel.add(myField, BorderLayout.NORTH);
        myPanel.add(myArea, BorderLayout.CENTER);
        myButtonPanel.add(myPrintButton, BorderLayout.CENTER);
        myButtonPanel.add(myShowHistoryButton, BorderLayout.LINE_END);
        myPanel.add(myButtonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(myPanel);

        myPrintButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setCurrentString(myField.getText());
                controller.printCurrentString();
            }
        });

        myShowHistoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                myArea.setText(controller.getHistory().toString());
            }
        });
    }

    /**
     * Method used to set the display of the I/O interface.
     */
    private void display() {

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}
