public class GreatestCommonDivisor {
    //Euclid algorithm
    public static int getGCD1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0 && result > 0) {
                result = GCD(result, arr[i]);
            } else {
                return 0;
            }
        }
        return result;
    }

    private static int GCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a < b) {
                a ^= b;
                b ^= a;
                a ^= b;
            }

            int temp = a % b;
            a = b;
            b = temp;
        }
        return a + b;
    }
    public static void main(String[] args) {
        int[] array = new int[]{12, 36, 48, 64};
        System.out.print(GCD.computeGCD(array));
    }
}