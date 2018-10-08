public class RecursionExample {

    public static void main(String[] args) {
        System.out.println(iterativeFactorial(3));
        System.out.println(recursiveFactorial(3));
    }

    private static int recursiveFactorial(int i) {
        if (i == 0) {
            return 1;
        }

        return i * recursiveFactorial(i - 1);
    }

    private static int iterativeFactorial(int i) {

        if (i == 0) {
            return 1;
        }

        int result = 1;
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }
}
