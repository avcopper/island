package com.javarush.island.cooper.constants;

public class AppConstants {
    public static final String APP_NAME = "Westworld";
    public static final String SETTINGS_FILE = "settings.json";
    public static final int PANE_WIDTH = 300;
    public static final int PANE_HEIGHT = 100;

    public static final int RESULT_NO_PLANT = 1;
    public static final int RESULT_NO_ANIMAL = 2;
    public static final int RESULT_NO_HERBIVORE = 3;
    public static final int RESULT_NO_PREDATOR = 4;

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String OPTIONPANE_MINIMUM_SIZE = "OptionPane.minimumSize";
    public static final String EMPTY_STRING = "";
    public static final String DELIMITER = "=================================================================================";
    public static final String NOT_FOUND_SETTINGS_FILE = "Not found settings file";
    public static final String UNKNOWN_ACTION = "unknown action";
    public static final String TOO_MUCH_ANIMALS = "Слишком много %s (%d). Максимум - %d. \nОни все не поместятся на данном острове. \nОтредактируйте файл настроек";
}
