package me.maxish0t;

import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class StringFunctions {

    public static final String ANSI_RESET;
    public static final String ANSI_BLACK;
    public static final String ANSI_RED;
    public static final String ANSI_GREEN;
    public static final String ANSI_YELLOW;
    public static final String ANSI_BLUE;
    public static final String ANSI_PURPLE;
    public static final String ANSI_CYAN;
    public static final String ANSI_WHITE;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Type a sentance please.");
        String inputString = input.nextLine();

        for (int i = 0; i < inputString.length(); i++) {
            coloredChar(inputString.charAt(i), ANSI_RED, ANSI_WHITE);
        }

        if (inputString.length() > 10) {
            coloredString("The string is greater than 10 letters.", ANSI_YELLOW, ANSI_WHITE);
        }

        alphabetOrganizer(inputString);

        String dictionary = "Dictionary.txt";
        getFileFromResources(dictionary);
        if (getFileFromResources(dictionary).exists()) {
            System.out.println("File Exits!");
        }
    }

    private static void alphabetOrganizer(String inputText) {
        String outputString = sortString(inputText);
        System.out.println("Alphabetical Input String : " + inputText);
        System.out.println("Alphabetical Output String : " + outputString);
    }

    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    private static String coloredString(String inputString, String colorBegin, String colorEnd) {
        System.out.println(colorBegin + inputString + colorEnd);
        return inputString;
    }

    private static void coloredChar(char inputString, String colorBegin, String colorEnd) {
        System.out.println(colorBegin + inputString + colorEnd);
    }

    private static File getFileFromResources(String fileName) {
        URL res = StringFunctions.class.getClassLoader().getResource(fileName);
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            coloredString("File " + fileName + " does NOT exist!", ANSI_BLUE, ANSI_WHITE);
        }
        return file;
    }
    
    static {
        ANSI_RESET = "\u001B[0m";
        ANSI_BLACK = "\u001B[30m";
        ANSI_RED = "\u001B[31m";
        ANSI_GREEN = "\u001B[32m";
        ANSI_YELLOW = "\u001B[33m";
        ANSI_BLUE = "\u001B[34m";
        ANSI_PURPLE = "\u001B[35m";
        ANSI_CYAN = "\u001B[36m";
        ANSI_WHITE = "\u001B[37m";
    }

}
