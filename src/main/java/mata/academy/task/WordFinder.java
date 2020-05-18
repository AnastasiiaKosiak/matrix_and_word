package mata.academy.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordFinder {
    public String findWordCoordinates(char[][] matrix, String word) {
        List<Coordinates> coordinates = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                search(matrix, word, i, j,0, coordinates);
            }
        }
        if (coordinates.size() == 0) {
            return "Cannot find a word";
        }
        return getCoordinates(coordinates);
    }

    private static String getCoordinates(List<Coordinates> coordinates) {
        Collections.reverse(coordinates);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < coordinates.size(); i++) {
            if (i != 0) {
                result.append(" -> ");
            }
            result.append('[')
                    .append(coordinates.get(i).getX())
                    .append(',')
                    .append(coordinates.get(i).getY())
                    .append(']');
        }
        return result.toString();
    }

    private static boolean search(char[][] matrix, String word, int i, int j, int index,
                                 List<Coordinates> list) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= columns) {
            return false;
        }
        if (matrix[i][j] == word.charAt(index)) {
            if (index == word.length() - 1) {
                list.add(Coordinates.of(i, j));
                return true;
            } else if (search(matrix, word, i + 1, j, index + 1, list)
                    || search(matrix, word, i - 1, j, index + 1, list)
                    || search(matrix, word, i, j + 1, index + 1, list)
                    || search(matrix, word, i, j - 1, index + 1, list)) {
                list.add(new Coordinates(i, j));
                return true;
            }
        }
        return false;
    }
}
