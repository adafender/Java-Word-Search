package Assignments;
// Assignment 6 - Word Search
// Ada Fender
import java.io.*;
import java.util.*;

public class Assignment6 {
    public static void main(String[] args) throws FileNotFoundException {

        char[][] grid = new char[6][6];

        // Read Grid.txt
        Scanner gridScanner = new Scanner(new File("Grid.txt"));
        for (int i = 0; i < 6; i++) {
            String line = gridScanner.nextLine();
            for (int j = 0; j < 6; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        gridScanner.close();

        Scanner dictScanner = new Scanner(new File("dictionary.txt"));
        // To find dictionary words
        while (dictScanner.hasNextLine()) {
            String dictWord = dictScanner.nextLine();
            int wordLength = dictWord.length();
            boolean wordFound = false;

            // Check horizontally
            for (int i = 0; i < 6 && wordFound == false; i++) {
                // Spots word could start in row
                for (int start = 0; start <= 6 - wordLength && wordFound == false; start++) {
                    String rowWord = "";
                    for (int j = start; j != (start + wordLength); j++) {
                        rowWord += grid[i][j];
                    }
                    // Print if word is found
                    if (rowWord.equals(dictWord)) {
                        System.out.println(dictWord);
                        wordFound = true;
                    }
                }
            }

            // Check vertically
            for (int j = 0; j < 6 && wordFound == false; j++) {
                // Spots word could start in row
                for (int start = 0; start <= 6 - wordLength && wordFound == false; start++) {
                    String colWord = "";
                    for (int i = start; i != (start + wordLength); i++) {
                        colWord += grid[i][j];
                    }
                    // Print if word is found
                    if (colWord.equals(dictWord)) {
                        System.out.println(dictWord);
                        wordFound = true;
                    }
                }
            }
        }

        dictScanner.close();
    }
}
