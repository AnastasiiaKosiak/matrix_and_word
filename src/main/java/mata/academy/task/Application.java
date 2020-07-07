package mata.academy.task;

public class Application {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("No arguments found");
        }
        String text = args[0];
        String word = args[1];
        if (!checkTextLength(text)) {
            throw new RuntimeException("Text length is not valid for matrix creation");
        }
        if (word.length() > text.length()) {
            throw new RuntimeException("Word length should not be bigger than the text length");
        }
        int matrixSize = (int) Math.sqrt(text.length());
        char[][] matrix = fillMatrix(text, matrixSize);
        WordFinder finder = new WordFinder();
        System.out.println(finder.findWordCoordinates(matrix, word));
    }

    private static char[][] fillMatrix(String text, int size) {
        char[][] matrix = new char[size][size];
        int stringIndex = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = text.charAt(stringIndex);
                stringIndex++;
            }
        }
        return matrix;
    }

    private static boolean checkTextLength(String text) {
        double squareRoot = Math.sqrt(text.length());
        return squareRoot - Math.floor(squareRoot) == 0;
    }
}
