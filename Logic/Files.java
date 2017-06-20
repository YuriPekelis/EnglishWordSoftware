package Logic;

import Windows.ErrorWindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Yuric on 01.05.2017.
 */
public class Files {

    private File unknownWordsFile =  new File (Const.UNKNOWN_WORDS_FILE_NAME);
    private File knownWordsFile = new File (Const.KNOWN_WORDS_FILE_NAME);
    //temporary files
    private File tempUnknownWordsFile = new File(Const.TEMP_UNKNOWN_WORDS_FILE_NAME);
    private File tempKnownWordsFile = new File(Const.TEMP_KNOWN_WORDS_FILE_NAME);

    private Scanner scnUnknownWords;
    private Scanner scnKnownWords;

    private FileWriter record;


    Files () {
        scnUnknownWords = openFile(unknownWordsFile);
        scnKnownWords = openFile(knownWordsFile);
    }
    //creating "res" folder if  it doesn`t exist
    public void makeFolder () {
        File folder = new File (Const.FOLDER_NAME);
        try {
            folder.mkdir();
        } catch (Exception e) {
            if (!folder.isDirectory())
                new ErrorWindow(Const.ERROR_DELETE_FILE_WITH_FOLDER_NAME);
        }

    }
    //make Scanner from file
    private Scanner openFile (File file) {

        makeFolder();
        // Exception if in the directory 'res' another directory with filename exists.
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                if (file.isDirectory())
                    new ErrorWindow(Const.ERROR_CANT_CREATE_NEW_FILES);
            }
        }
        else {
            if (file.isDirectory())
                new ErrorWindow(Const.ERRROR_DIRECTORY_IS_CREATED);
        }
        Scanner scan = null;
        try {
            scan = new Scanner (file);
        } catch (FileNotFoundException e) {
            new ErrorWindow(Const.ERROR_CANT_CREATE_NEW_FILES);
        }
        return scan;
    }

    public Scanner getUnknownWordsScanner () {
        return scnUnknownWords;
    }

    public Scanner getKnownWordsScanner () {
        return scnKnownWords;
    }
    // saving changed libraries to files
    public void exitFiles (Libraries libraries) {
        StringBuffer line = new StringBuffer();
        try {
            tempUnknownWordsFile.createNewFile();
            record = new FileWriter(tempUnknownWordsFile);
            for (int i=0; i < libraries.getSizeUnknownLibrary(); i++) {
                line.setLength(0);
                line.append(libraries.getUnknownWordByNumber(i).getWord());
                line.append(Const.SEPARATOR_IN_FILE);
                line.append(libraries.getUnknownWordByNumber(i).getTranslation());
                line.append(Const.SEPARATOR_IN_FILE);
                line.append(libraries.getUnknownWordByNumber(i).getTriesRemainToKnow());
                line.append(Const.SEPARATOR_IN_FILE);
                line.append(libraries.getUnknownWordByNumber(i).getSwapWordAndTranslation());
                line.append('\n');
                record.write(line.toString());
            }
            record.close();
        } catch (IOException e) {
            new ErrorWindow(Const.ERROR_CANT_RECORD_FILE);
        }

        try {
            tempKnownWordsFile.createNewFile();
            record = new FileWriter(tempKnownWordsFile);
            for (int i=0; i < libraries.getSizeKnownLibrary(); i++) {
                line.setLength(0);
                line.append(libraries.getKnownWordByNumber(i).getWord());
                line.append(Const.SEPARATOR_IN_FILE);
                line.append(libraries.getKnownWordByNumber(i).getTranslation());
                line.append(Const.SEPARATOR_IN_FILE);
                line.append(libraries.getKnownWordByNumber(i).getSwapWordAndTranslation());
                line.append('\n');
                record.write(line.toString());
            }
            record.close();
        } catch (IOException e) {
            new ErrorWindow(Const.ERROR_CANT_RECORD_FILE);
        }
        unknownWordsFile.delete();
        knownWordsFile.delete();
        tempUnknownWordsFile.renameTo(unknownWordsFile);
        tempKnownWordsFile.renameTo(knownWordsFile);
        System.exit(0);

    }
}
