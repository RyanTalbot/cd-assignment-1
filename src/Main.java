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

        String word = "fun";
        int totalCount;

        int[] x = {0, 1, 1};
        int[] y = {1, 0, 1};

        SearchThread thread1 = new SearchThread(charArray, x[0], y[0], word);
        SearchThread thread2 = new SearchThread(charArray, x[1], y[1], word);
        SearchThread thread3 = new SearchThread(charArray, x[2], y[2], word);

        Thread threadT1 = new Thread(thread1);
        Thread threadT2 = new Thread(thread2);
        Thread threadT3 = new Thread(thread3);

        long start = System.currentTimeMillis();

        threadT1.start();
        threadT2.start();
        threadT3.start();
        threadT1.join();
        threadT2.join();
        threadT3.join();

        long end = System.currentTimeMillis();

        totalCount = thread1.getWordCount() + thread2.getWordCount() + thread3.getWordCount();
        System.out.println("Count: " + totalCount);
        System.out.println("Time: " + (end - start));
    }
}
