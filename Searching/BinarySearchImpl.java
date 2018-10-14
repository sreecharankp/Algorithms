public class BinarySearchImpl {
    public static void main(String[] args) {
        int[] array = {-22, -15, 1, 7, 20, 35, 55};

        System.out.println(binarySearchUsingIterarive(array, -15));
        System.out.println(binarySearchUsingIterarive(array, 1));
        System.out.println(binarySearchUsingIterarive(array, 8888));
        System.out.println(binarySearchUsingIterarive(array, -22));
        System.out.println();
        System.out.println(binarySearchUsingRecursive(array, -15));
        System.out.println(binarySearchUsingRecursive(array, 1));
        System.out.println(binarySearchUsingRecursive(array, 8888));
        System.out.println(binarySearchUsingRecursive(array, -22));
    }

    private static int binarySearchUsingRecursive(int[] array, int value) {
        return binarySearchUsingRecursive(array, 0, array.length, value);
    }

    private static int binarySearchUsingRecursive(int[] array, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] < value) {
            return binarySearchUsingRecursive(array, mid + 1, end, value);
        } else {
            return binarySearchUsingRecursive(array, start, mid, value);
        }
    }

    private static int binarySearchUsingIterarive(int[] array, int value) {

        int start = 0;
        int end = array.length;

        while (start < end) {
            int mid = (end + start) / 2;

            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
