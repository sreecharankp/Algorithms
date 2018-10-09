import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    public static void main(String[] args) throws IOException {
         /*
        Array before sorting: 20 35 -15 7 55 1 -22
        Array after sorting: -22 -15 1 7 20 35 55
        Time complexity is: O(n log n)
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

        doQuickSort(sortArray, 0, sortArray.length);

        StringBuilder builderSort = new StringBuilder();
        for (int j : sortArray) {
            builderSort.append(j + " ");
        }
        System.out.println("Array after sorting: " + builderSort);

    }

    private static void doQuickSort(int[] sortArray, int start, int end) {

        if ((end - start) < 2) {
            return;
        }

        int pivot = partition(sortArray, start, end);
        doQuickSort(sortArray, start, pivot);
        doQuickSort(sortArray, pivot + 1, end);
    }

    private static int partition(int[] sortArray, int start, int end) {

        int pivot = sortArray[start];
        int i = start;
        int j = end;

        while (i < j) {

            while (i < j && sortArray[--j] >= pivot) ;
            if (i < j) {
                sortArray[i] = sortArray[j];
            }

            while (i < j && sortArray[++i] <= pivot) ;
            if (i < j) {
                sortArray[j] = sortArray[i];
            }
        }
        sortArray[j] = pivot;
        return j;
    }
}
