package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    /**
     * 
     * @param controller to handle the functionig of I/O inteface
     */
    public SimpleGUI(final Controller controller) {
        frame.setName("My first java graphical interface");
        final JPanel myPanel = new JPanel(new BorderLayout());
        final JTextArea myArea = new JTextArea();
        final JButton myButton = new JButton("Save");
        myPanel.add(myArea, BorderLayout.CENTER);
        myPanel.add(myButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(myPanel);
        frame.pack();
        frame.setVisible(true);

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
    }
    /**
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new Controller());
    }

}
