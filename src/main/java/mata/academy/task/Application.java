package mata.academy.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("No arguments found");
        }
        String string = args[0];
        String word = args[1];
        int matrixSize = (int) Math.sqrt(string.length());
        if (word.length() > string.length()) {
            throw new RuntimeException("Word length should not be bigger than the string length");
        }
        char[][] matrix = fillMatrix(string, matrixSize);
        findWord(matrix, word);
    }

    private static char[][] fillMatrix(String string, int size) {
        char[][] matrix = new char[size][size];
        int m = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = string.charAt(m);
                m++;
            }
        }
        return matrix;
    }

    public static boolean findWord(char[][] matrix, String word) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean letterFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (search(matrix, word, i, j,0, list)) {
                    letterFound = true;
                }
            }
        }
        if (list.size() == 0) {
            System.out.println("Cannot find a word");
        } else {
            printCoordinates(list);
        }
        return letterFound;
    }

    public static void printCoordinates(List<Integer> coordinates) {
        Collections.reverse(coordinates);
        for (int i = 0; i < coordinates.size(); i++) {
            System.out.print(coordinates.get((i)) + " ");
            if (i % 2 != 0) {
                System.out.println();
            }
        }
    }

    public static boolean search(char[][] matrix, String word, int i, int j, int index,
                                 List<Integer> list) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= columns) {
            return false;
        }
        if (matrix[i][j] == word.charAt(index)) {
            if (index == word.length() - 1) {
                list.add(j);
                list.add(i);
                return true;
            } else if (search(matrix, word, i + 1, j, index + 1, list)
                    || search(matrix, word, i - 1, j, index + 1, list)
                    || search(matrix, word, i, j + 1, index + 1, list)
                    || search(matrix, word, i, j - 1, index + 1, list)) {
                list.add(j);
                list.add(i);
                return true;
            }
        }
        return false;
    }
}
