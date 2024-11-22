package it.unibo.mvc;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    /**
     * 
     * @param controller to handle the functionig of I/O inteface
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        frame.setName("My first java graphical interface");
        final JPanel myPanel = new JPanel(new BorderLayout());
        final JPanel mySecondPanel = new JPanel(new BorderLayout());
        final JTextArea myArea = new JTextArea();
        final JTextField myField = new JTextField(controller.getFilePath());
        myField.setEditable(false);
        final JButton myButton = new JButton("Save");
        final JButton myBrowseButton = new JButton("Browse");
        mySecondPanel.add(myField, BorderLayout.CENTER);
        mySecondPanel.add(myBrowseButton, BorderLayout.LINE_END);
        myPanel.add(mySecondPanel, BorderLayout.NORTH);
        myPanel.add(myArea, BorderLayout.CENTER);
        myPanel.add(myButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(myPanel);

        myButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final String text = myArea.getText();
                try {
                    controller.writeOnFile(text);
                } catch (IOException exception) {
                    System.out.println("Errore di IO"); // NOPMD: esercizio
                }
            }
        });
        myBrowseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser myFileChooser = new JFileChooser();
                final int userAction = myFileChooser.showSaveDialog(myBrowseButton);
                if (userAction == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(myFileChooser.getSelectedFile());
                    myField.setText(controller.getFilePath());

                } else if (userAction == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(new JPanel(), JOptionPane.ERROR_MESSAGE);
                }
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
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
