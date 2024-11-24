package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME_DIRECTORY = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";

    private File currentFile;
    /**
     * 
     */
    public Controller() {
        this.currentFile = new File(HOME_DIRECTORY + File.separator + DEFAULT_FILE);
    }
    /**
     * 
     * @param file the file the user wants to set as current file
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }
    /**
     * 
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }
    /**
     * 
     * @return the string of the path of current file
     */
    public String getFilePath() {
        return this.currentFile.getAbsolutePath();
    }
    /**
     * 
     * @param sentence the frase the user wants to save on the current file
     * @throws IOException
     */
    public void writeOnFile(final String sentence) throws IOException {
        Files.writeString(this.currentFile.toPath(), sentence); 
    }
}
