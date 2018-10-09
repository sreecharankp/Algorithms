import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortReverseOrder {

    public static void main(String[] args) throws IOException {
        /*
        Array before sorting: 20 35 -15 7 55 1 -22
        Array after sorting: 55 35 20 7 1 -15 -22
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

        mergeSortReverse(sortArray, 0, sortArray.length);

        StringBuilder builderSort = new StringBuilder();
        for (int j : sortArray) {
            builderSort.append(j + " ");
        }
        System.out.println("Array after sorting: " + builderSort);
    }

    private static void mergeSortReverse(int[] sortArray, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSortReverse(sortArray, start, mid);
        mergeSortReverse(sortArray, mid, end);
        merge(sortArray, start, mid, end);
    }

    private static void merge(int[] sortArray, int start, int mid, int end) {
        if (sortArray[mid - 1] >= sortArray[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] tempArray = new int[end - start];
        while (i < mid && j < end) {
            tempArray[tempIndex++] = sortArray[i] >= sortArray[j] ? sortArray[i++] : sortArray[j++];
        }

        System.arraycopy(sortArray, i, sortArray, start + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, sortArray, start, tempIndex);
    }
}
