package it.unibo.mvc;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String currentString;
    private final List<String> history = new ArrayList<>();

    /**
     * Constructor used to initialize a new controller without
     * setting the current string.
     */
    public SimpleController() {
        this.currentString = "";
    }

    /**
     * 
     * @param string is the new string the user wants to set as
     * current string
     */
    public SimpleController(final String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.currentString = string;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentString(final String newString) {
        if (newString.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.currentString = newString;
        this.history.add(newString);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCurrentString() {
        return this.currentString;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHistory() {
        return List.copyOf(history); 

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printCurrentString() {
        if (this.currentString.isBlank()) {
            throw new IllegalStateException();
        }
        System.out.println(getCurrentString()); //NOPMD: the exercise 
        //requires the usage of sout
    }

}
