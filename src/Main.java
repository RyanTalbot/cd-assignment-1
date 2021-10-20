import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Core given code start
        Random randomGenerator = new Random();
        char[][] charArray = new char[50][50];

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
    }
}
