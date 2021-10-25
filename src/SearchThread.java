public class SearchThread implements Runnable {

    private char wordSearchArray[][];
    private String word;
    private int rows, columns, wordCount, xInc, yInc;

    public SearchThread(char[][] wordSearchArray, String word, int xInc, int yInc) {
        this.wordSearchArray = wordSearchArray;
        this.word = word;
        this.rows = wordSearchArray.length;
        this.columns = wordSearchArray[0].length;
        this.wordCount = 0;
        this.xInc = xInc;
        this.yInc = yInc;
    }

    @Override
    public void run() {
        
    }
}
