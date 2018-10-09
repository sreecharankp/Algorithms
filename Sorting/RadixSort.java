import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RadixSort {
    public static void main(String[] args) throws IOException {
        /*
        input: 4725 4586 1330 8792 1594 5729
        output: 1330 1594 4586 4725 5729 8792
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the length of the array:");
        int length = Integer.valueOf(reader.readLine());
        System.out.println("Enter " + length + " Elements");
        int[] sortArray = new int[length];
        for (int i = 0; i < sortArray.length; i++) {
            sortArray[i] = Integer.valueOf(reader.readLine());
        }
        StringBuilder builder = new StringBuilder();
        for (int i : sortArray) {
            builder.append(i + " ");
        }
        System.out.println("Array before sorting: " + builder);

        radixSort(sortArray, 10, 4);

        StringBuilder builderSort = new StringBuilder();
        for (int j : sortArray) {
            builderSort.append(j + " ");
        }
        System.out.println("Array after sorting: " + builderSort);
    }

    private static void radixSort(int[] sortArray, int radix, int width) {

        for (int i = 0; i < width; i++) {
            radixSingleSort(sortArray, i, radix);
        }
    }

    private static void radixSingleSort(int[] sortArray, int postition, int radix) {
        int numItems = sortArray.length;
        int[] countArray = new int[radix];

        for (int i : sortArray) {
            countArray[getDigit(i, postition, radix)]++;
        }

        for (int i = 1; i < radix; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] temp = new int[numItems];
        for (int i = numItems - 1; i >= 0; i--) {
            temp[--countArray[getDigit(sortArray[i], postition, radix)]] = sortArray[i];
        }

        for (int i = 0; i < numItems; i++) {
            sortArray[i] = temp[i];
        }
    }

    private static int getDigit(int number, int postition, int radix) {
        return number / (int) Math.pow(radix, postition) % radix;
    }
}
