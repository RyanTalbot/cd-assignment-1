import java.util.concurrent.atomic.AtomicInteger;

public class SearchThread implements Runnable {

    static AtomicInteger wordCount = new AtomicInteger(0);
    private char[][] wordSearchArray;
    private String direction;

    public SearchThread(char[][] wordSearchArray, String direction) {
        this.wordSearchArray = wordSearchArray;
        this.direction = direction;
    }

    @Override
    public void run() {

        switch (this.direction) {
            case "vertical":
                verticalSearch(wordSearchArray);
            case "horizontal":
                horizontalSearch(wordSearchArray);
            case "diagonal":
                diagonalSearch(wordSearchArray);
                break;
        }

    }

    public static void verticalSearch(char[][] wordSearchArray) {

        for (int row = 0; row < wordSearchArray.length; row++) {
            for (int col = 0; col < wordSearchArray.length - 2; col++) {
                if (wordSearchArray[row][col] == 102 && wordSearchArray[row][col + 1] == 117 && wordSearchArray[row][col + 2] == 110) {
                    incrementWordCount();
                }
            }
        }

    }

    public static void horizontalSearch(char[][] wordSearchArray) {

        for (int row = 0; row < wordSearchArray.length - 2; row++) {
            for (int col = 0; col < wordSearchArray.length; col++) {
                if (wordSearchArray[row][col] == 102 && wordSearchArray[row + 1][col] == 117 && wordSearchArray[row + 2][col] == 110) {
                    incrementWordCount();
                }
            }
        }
    }

    public static void diagonalSearch(char[][] wordSearchArray) {

        // Upper diagonal search
        for (int row = 2; row < wordSearchArray.length; row++) {
            for (int col = 0; col < wordSearchArray.length - 2; col++) {
                if (wordSearchArray[row][col] == 102 && wordSearchArray[row - 1][col + 1] == 117 && wordSearchArray[row - 2][col + 2] == 110) {
                    incrementWordCount();
                }
            }
        }

        // Lower diagonal search
        for (int row = 0; row < wordSearchArray.length - 2; row++) {
            for (int col = 0; col < wordSearchArray.length - 2; col++) {
                if (wordSearchArray[row][col] == 102 && wordSearchArray[row + 1][col + 1] == 117 && wordSearchArray[row + 2][col + 2] == 110) {
                    incrementWordCount();
                }
            }
        }
    }

    public static void incrementWordCount() {
        wordCount.incrementAndGet();
    }

    public static int getWordCount() {
        return wordCount.get();
    }
}