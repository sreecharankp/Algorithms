import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSortRecurssion {

    public static void main(String[] args) throws IOException {
        /*
        Array before sorting: 20 35 -15 7 55 1 -22
        Array after sorting: -22 -15 1 7 20 35 55
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

        insertionSort(sortArray, sortArray.length);
    }

    private static void insertionSort(int[] sortArray, int length) {

        if (length < 2) {
            return;
        }

        insertionSort(sortArray, length - 1);

        int newElement = sortArray[length - 1];
        int i;
        for (i = length - 1; i > 0 && sortArray[i - 1] > newElement; i--) {
            sortArray[i] = sortArray[i - 1];
        }

        sortArray[i] = newElement;

        System.out.println("Result of call when numItems: " + length);
        for (i=0;i<sortArray.length;i++){
            System.out.print(sortArray[i]);
            System.out.println(", ");
        }
        System.out.println("");
        System.out.println("----------------------");
    }
}
