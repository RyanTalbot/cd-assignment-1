import java.util.Random;

/*
This is a program to search for the word "fun" in a 1000x1000
character array. We first instantiate a counter object then
generate our working array. We then create 3 threads to search
in each direction by passing the corresponding runnable.

As each thread works on its task, the counter variable is
update in a thread safe manor by using synchronized in its
class methods which increment and return the count.

Results are coming back with a word count of ~200 which is
what we were expecting. Runtime is also calculated and shown.
 */

public class Main {

    // Counter object to track word count across multiple threads
    static Counter counter = new Counter();

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

        // Creating a new thread for each search direction
        Thread verticalSearchThread = new Thread(verticalSearch(charArray));
        Thread horizontalSearchThread = new Thread(horizontalSearch(charArray));
        Thread diagonalSearchThread = new Thread(diagonalSearch(charArray));

        // Starting to measure run time
        long start = System.currentTimeMillis();

        // Starting the 3 threads
        verticalSearchThread.start();
        horizontalSearchThread.start();
        diagonalSearchThread.start();

        // Merging the results
        verticalSearchThread.join();
        horizontalSearchThread.join();
        diagonalSearchThread.join();

        // Done measuring run time
        long end = System.currentTimeMillis();

        // Getting the total word count
        int totalCount = counter.getCount();

        // Results
        System.out.println("Count: " + (totalCount));
        System.out.println("Time: " + (end - start) + "ms");
    }

    /*
    Vertical search which iterates through each element in a column
    and if it finds the first letter of the word in question, checks
    the next 2. If found it increments the count.
     */
    private static Runnable verticalSearch(char[][] wordSearchArray) {
        return () -> {
            for (int row = 0; row < wordSearchArray.length; row++) {
                for (int col = 0; col < wordSearchArray.length - 2; col++) {
                    if (wordSearchArray[row][col] == 102 && wordSearchArray[row][col + 1] == 117 && wordSearchArray[row][col + 2] == 110) {
                        counter.incrementAndGet();
                    }
                }
            }
        };
    }

    /*
    Exact same as the vertical search but works on the horizontal axis
     */
    private static Runnable horizontalSearch(char[][] wordSearchArray) {
        return  () -> {
            for (int row = 0; row < wordSearchArray.length - 2; row++) {
                for (int col = 0; col < wordSearchArray.length; col++) {
                    if (wordSearchArray[row][col] == 102 && wordSearchArray[row + 1][col] == 117 && wordSearchArray[row + 2][col] == 110) {
                        counter.incrementAndGet();
                    }
                }
            }
        };
    }

    /*
    Again similar to previous searches just we search for upper and
    lower diagonal separately.
     */
    private static Runnable diagonalSearch(char[][] wordSearchArray) {
        return () -> {
            // Upper diagonal search
            for (int row = 2; row < wordSearchArray.length; row++) {
                for (int col = 0; col < wordSearchArray.length - 2; col++) {
                    if (wordSearchArray[row][col] == 102 && wordSearchArray[row - 1][col + 1] == 117 && wordSearchArray[row - 2][col + 2] == 110) {
                        counter.incrementAndGet();
                    }
                }
            }

            // Lower diagonal search
            for (int row = 0; row < wordSearchArray.length - 2; row++) {
                for (int col = 0; col < wordSearchArray.length - 2; col++) {
                    if (wordSearchArray[row][col] == 102 && wordSearchArray[row + 1][col + 1] == 117 && wordSearchArray[row + 2][col + 2] == 110) {
                        counter.incrementAndGet();
                    }
                }
            }
        };
    }
}
