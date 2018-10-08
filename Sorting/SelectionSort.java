import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

    public static void main(String[] args) throws IOException {

        /*
        Array before sorting: 20 35 -15 7 55 1 -22
        Array after sorting: -22 -15 1 7 20 35 55
        Time complexity is: O(n ^ 2)
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

        for (int i = sortArray.length - 1; i > 0; i--) {
            int largest = 0;
            for (int j = 0; j <= i; j++) {
                if (sortArray[j] > sortArray[largest]) {
                    largest = j;
                }
            }
            swapElement(sortArray, largest, i);
        }
        StringBuilder builderSort = new StringBuilder();
        for (int j : sortArray) {
            builderSort.append(j + " ");
        }
        System.out.println("Array after sorting: " + builderSort);
    }

    private static void swapElement(int[] sortArray, int i, int i1) {
        if (i == i1) {
            return;
        }

        int temp = sortArray[i];
        sortArray[i] = sortArray[i1];
        sortArray[i1] = temp;
    }
}
