import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellSort {

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

        //Find gap value, once gap value becomes 1, then its normal insertion sort
        for (int gap = sortArray.length / 2; gap > 0; gap /= 2) {

            //Insertion sort
            for (int i = gap; i < sortArray.length; i++) {
                int newvalue = sortArray[i];

                int j;
                for (j = i; j >= gap && sortArray[j - gap] > newvalue; j -= gap) {
                    sortArray[j] = sortArray[j - gap];
                }

                sortArray[j] = newvalue;
            }
        }

        StringBuilder builderSort = new StringBuilder();
        for (int j : sortArray) {
            builderSort.append(j + " ");
        }
        System.out.println("Array after sorting: " + builderSort);
    }
}
