import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingSort {
    public static void main(String[] args) throws IOException {
         /*
        **Counting sort wholes good for numbers with in the range, it wont work for negetive numbers
        Array before sorting: 2 5 9 8 2 8 7 10 4 3
        Array after sorting: 2 2 3 4 5 7 8 8 9 10
        Time complexity is: O(n)
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

        countingSort(sortArray, 1, 10);

        StringBuilder builderSort = new StringBuilder();
        for (int j : sortArray) {
            builderSort.append(j + " ");
        }
        System.out.println("Array after sorting: " + builderSort);
    }

    private static void countingSort(int[] sortArray, int min, int max) {

        int[] tempArray = new int[max - min + 1];

        for (int i = 0; i < sortArray.length; i++) {
            tempArray[sortArray[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (tempArray[i - min] > 0) {
                sortArray[j++] = i;
                tempArray[i - min]--;
            }
        }
    }
}
