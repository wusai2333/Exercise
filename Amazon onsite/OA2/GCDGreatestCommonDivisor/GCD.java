public class GCD {
    public static int computeGCD(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // compute gcd one by one;
            gcd = gcd(gcd, nums[i]);
        }
        return gcd;
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) return 0;
        while (a != 0 && b != 0) {
            if (b > a) {
                a ^= b;
                b ^= a;
                a ^= b;
            }
            int temp = a % b;
            a  = b;
            b = temp;
        }
        return a + b;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 36, 48, 64};
        System.out.print(GCD.computeGCD(array));
    }
}