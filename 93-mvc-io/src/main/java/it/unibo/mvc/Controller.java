package it.unibo.mvc;
import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * 
     * @param newString is the string the user wants to set as current string
     */
    void setCurrentString(String newString);

    /**
     * @return the current string
     */
    String getCurrentString();

    /**
     * 
     * @return the history of the strings that were once current and 
     * the actual current
     */
    List<String> getHistory();

    /**
     * Method used to print the current string on the standard output.
    */
    void printCurrentString();
}
