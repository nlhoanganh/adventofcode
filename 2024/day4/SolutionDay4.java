package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SolutionDay4 {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines(Path.of("day4/input.txt"));

       
        int width = inputLines.get(0).length();
        int height = inputLines.size();
        int counter = 0;

         // Part 1
        char[] neededChars = new char[]{'M', 'A', 'S'};
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                if (inputLines.get(i).charAt(j) != 'X') {
                    continue;
                }
                
                // Look to the right
                int moves = 0;
                int heightPointer = i;
                int widthPointer = j + 1;

                while (widthPointer < width && moves < 3) {
                    char selectedChar = inputLines.get(heightPointer).charAt(widthPointer);
                    if (selectedChar == neededChars[moves]) {
                        widthPointer++;
                        moves++;

                        if (moves == 3) {
                            counter++;
                        }
                    } else {
                        break;
                    }
                }
                
                // Look to the left
                moves = 0;
                heightPointer = i;
                widthPointer = j - 1;

                while (widthPointer >= 0 && moves < 3) {
                    char selectedChar = inputLines.get(heightPointer).charAt(widthPointer);
                    if (selectedChar == neededChars[moves]) {
                        widthPointer--;
                        moves++;

                        if (moves == 3) {
                            counter++;
                        }
                    } else {
                        break;
                    }
                }

                // Look up
                moves = 0;
                heightPointer = i - 1;
                widthPointer = j;

                while (heightPointer >= 0 && moves < 3) {
                    char selectedChar = inputLines.get(heightPointer).charAt(widthPointer);
                    if (selectedChar == neededChars[moves]) {
                        heightPointer--;
                        moves++;

                        if (moves == 3) {
                            counter++;
                        }
                    } else {
                        break;
                    }
                }

                // Look down
                moves = 0;
                heightPointer = i + 1;
                widthPointer = j;

                while (heightPointer < height && moves < 3) {
                    char selectedChar = inputLines.get(heightPointer).charAt(widthPointer);
                    if (selectedChar == neededChars[moves]) {
                        heightPointer++;
                        moves++;

                        if (moves == 3) {
                            counter++;
                        }
                    } else {
                        break;
                    }
                }

                // Look upper left
                moves = 0;
                heightPointer = i - 1;
                widthPointer = j - 1;

                while (heightPointer >= 0 && widthPointer >= 0 && moves < 3) {
                    char selectedChar = inputLines.get(heightPointer).charAt(widthPointer);
                    if (selectedChar == neededChars[moves]) {
                        widthPointer--;
                        heightPointer--;
                        moves++;

                        if (moves == 3) {
                            counter++;
                        }
                    } else {
                        break;
                    }
                }

                // Look upper right
                moves = 0;
                heightPointer = i - 1;
                widthPointer = j + 1;

                while (heightPointer >= 0 && widthPointer < width && moves < 3) {
                    char selectedChar = inputLines.get(heightPointer).charAt(widthPointer);
                    if (selectedChar == neededChars[moves]) {
                        widthPointer++;
                        heightPointer--;
                        moves++;

                        if (moves == 3) {
                            counter++;
                        }
                    } else {
                        break;
                    }
                }

                // Look lower left
                moves = 0;
                heightPointer = i + 1;
                widthPointer = j - 1;

                while (heightPointer < height && widthPointer >= 0 && moves < 3) {
                    char selectedChar = inputLines.get(heightPointer).charAt(widthPointer);
                    if (selectedChar == neededChars[moves]) {
                        widthPointer--;
                        heightPointer++;
                        moves++;

                        if (moves == 3) {
                            counter++;
                        }
                    } else {
                        break;
                    }
                }

                // Look lower right
                moves = 0;
                heightPointer = i + 1;
                widthPointer = j + 1;

                while (heightPointer < height && widthPointer < width && moves < 3) {
                    char selectedChar = inputLines.get(heightPointer).charAt(widthPointer);
                    if (selectedChar == neededChars[moves]) {
                        widthPointer++;
                        heightPointer++;
                        moves++;

                        if (moves == 3) {
                            counter++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(counter);


        // Part 2
        counter = 0;
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                if (inputLines.get(i).charAt(j) != 'A' || i == 0 || j == 0 || i == (height - 1) || j == width - 1) {
                    continue;
                }

                char upperLeftChar = inputLines.get(i - 1).charAt(j - 1);
                char upperRightChar = inputLines.get(i - 1).charAt(j + 1);
                char lowerLeftChar = inputLines.get(i + 1).charAt(j - 1);
                char lowerRightChar = inputLines.get(i + 1).charAt(j + 1);

                boolean oneHalfValid = false;
                boolean secondHalfValid = false;

                if (upperLeftChar == 'M' && lowerRightChar == 'S') {
                    oneHalfValid = true;
                } else if (upperLeftChar == 'S' && lowerRightChar == 'M') {
                    oneHalfValid = true;
                }

                if (upperRightChar == 'M' && lowerLeftChar == 'S') {
                    secondHalfValid = true;
                } else if (upperRightChar == 'S' && lowerLeftChar == 'M') {
                    secondHalfValid = true;
                }

                if (oneHalfValid && secondHalfValid) {
                    counter++;
                }
            }
        }
        System.out.println(counter);

    }
}