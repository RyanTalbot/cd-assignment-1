import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Core given code start
        Random randomGenerator = new Random();
        char[][] charArray = new char[1000][1000];


        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                charArray[i][j] = (char) (randomGenerator.nextInt(26) + 97);
            }
        }

//        charArray[0][0] = 'f';
//        charArray[1][1] = 'u';
//        charArray[2][2] = 'n';
//
//        charArray[5][3] = 'f';
//        charArray[6][4] = 'u';
//        charArray[7][5] = 'n';
//
//        charArray[2][7] = 'f';
//        charArray[3][8] = 'u';
//        charArray[4][9] = 'n';

        for (int k = 0; k < charArray.length; k++) {
            System.out.printf("%-3d", k);
        }
        System.out.println();

        for (char[] chars : charArray) {
            for (char aChar : chars) {
                System.out.print(aChar + "  ");
            }
            System.out.println();
        }
        // Core given code finish

        SearchThread verticalSearch = new SearchThread(charArray, "vertical");
        SearchThread horizontalSearch = new SearchThread(charArray, "horizontal");
        SearchThread diagonalSearch = new SearchThread(charArray, "diagonal");

        Thread threadT1 = new Thread(verticalSearch);
        Thread threadT2 = new Thread(horizontalSearch);
        Thread threadT3 = new Thread(diagonalSearch);

        long start = System.currentTimeMillis();

        threadT1.start();
        threadT2.start();
        threadT3.start();
        threadT1.join();
        threadT2.join();
        threadT3.join();

        long end = System.currentTimeMillis();

        int totalCount = SearchThread.getWordCount();

        System.out.println("Count: " + (totalCount));
        System.out.println("Time: " + (end - start));
    }
}
