public class SearchThread implements Runnable {

    private static int wordCount;
    private char[][] wordSearchArray;
    private String direction;

    public SearchThread(char[][] wordSearchArray, String direction) {
        this.wordSearchArray = wordSearchArray;
        this.direction = direction;
    }

    @Override
    public void run() {

        switch (this.direction) {
            case "vertical" :
                verticalSearch(wordSearchArray);
            case "horizontal" :
                horizontalSearch(wordSearchArray);
            case "diagonal" :
                diagonalSearch(wordSearchArray);
                break;
        }

    }

    public static void verticalSearch(char[][] wordSearchArray) {

        String str = null;

        for (int row = 0; row < wordSearchArray.length; row++) {
            for (int col = 0; col < wordSearchArray.length - 2; col++) {
                if (wordSearchArray[row][col] == 102 && wordSearchArray[row][col + 1] == 117 && wordSearchArray[row][col + 2] == 110) {
                    wordCount++;
                }
            }
        }

    }

    public static void horizontalSearch(char[][] wordSearchArray) {

        String str = null;

        for (int row = 0; row < wordSearchArray.length - 2; row++) {
            for (int col = 0; col < wordSearchArray.length; col++) {
                if (wordSearchArray[row][col] == 102 && wordSearchArray[row + 1][col] == 117 && wordSearchArray[row + 2][col] == 110) {
                    wordCount++;
                }
            }
        }
    }

    public static void diagonalSearch(char[][] wordSearchArray) {

        String str = null;

        // Upper diagonal search
        for (int row = 2; row < wordSearchArray.length; row++) {
            for (int col = 0; col < wordSearchArray.length - 2; col++) {
                if (wordSearchArray[row][col] == 102 && wordSearchArray[row - 1][col + 1] == 117 && wordSearchArray[row - 2][col + 2] == 110) {
                    wordCount++;
                }
            }
        }

        // Lower diagonal search
        for (int row = 0; row < wordSearchArray.length - 2; row++) {
            for (int col = 0; col < wordSearchArray.length - 2; col++) {
                if (wordSearchArray[row][col] == 102 && wordSearchArray[row + 1][col + 1] == 117 && wordSearchArray[row + 2][col + 2] == 110) {
                    wordCount++;
                }
            }
        }
    }

    public int getWordCount() {
        return wordCount;
    }
}
