package Logic;

/**
 * Created by Yuric on 01.05.2017.
 */
public class Const {

    //Text for labels with unknown / known words
    public static final String UNKNOWN_WORDS = "Unknown words";
    public static final String KNOWN_WORDS = "Known words";

    public static final int NUMBER_OF_TRIES_TO_LEARN = 10;
    //after this number good tries word is learned, every bad try increase it
    public static final int NUMBER_WORD_PARAMETERS = 3; // word, translation, flag for order of testing

    public static final String FOLDER_NAME = "res"; //folder for libraries
    public static final String UNKNOWN_WORDS_FILE_NAME = "res//unknownwords.txt"; //filename for unknown words
    public static final String KNOWN_WORDS_FILE_NAME = "res//knownwords.txt"; //filename for known words
    public static final String TEMP_KNOWN_WORDS_FILE_NAME = "res//tempknownwords.txt"; //temporary filename for unknown words
    public static final String TEMP_UNKNOWN_WORDS_FILE_NAME = "res//tempunknownwords.txt"; //temporary filename for known words

    public static final String SEPARATOR_IN_FILE = " #%& "; //separation between columns

    public static final String NO_WORDS = "No words in this library.";
    public static final String ERROR_DELETE_FILE_WITH_FOLDER_NAME = "We can`t create subfolder. " +
            "Please delete from the program folder file: "; //there is a file with folder name
    public static final String ERROR_CANT_RECORD_FILE = "Please delete files with temp from \\res folder."; //error - can`t record file
    public static final String ERRROR_DIRECTORY_IS_CREATED = "Please delete all folders in '\\res' folder."; //error - folder with filename
    public static final String ERROR_CANT_CREATE_NEW_FILES = "We can`t create new file - IO error."; //error - can`t create new file
    public static final String ERROR_FILE_STRUCTURE = "There is an error with the structure of datafile. " +
            "Delete them and add words again."; //error with file structure

    public static final String ADD_WORD_MESSAGE_ADDED = "Word was added to array. It will be added to file after exit.";
    public static final String ADD_WORD_MESSAGE_ERROR = "Error! Please fill both fields.";
    public static final String ADD_WORD_MESSAGE_FILL = "Fill both fields";


}
