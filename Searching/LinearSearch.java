public class LinearSearch {
    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        System.out.println(linearSearch(array, -15));
        System.out.println(linearSearch(array, 1));
        System.out.println(linearSearch(array, 8888));
        System.out.println(linearSearch(array, -22));
    }

    private static int linearSearch(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
