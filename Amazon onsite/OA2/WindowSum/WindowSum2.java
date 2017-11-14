import java.util.Arrays;
public class WindowSum2 {
    public static int[] getSum(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) return new int[0];
        int[] result = new int[array.length - k + 1];
        // sum of first k nums;
        for (int i = 0; i < k; i++) {
            result[0] += array[i];
        }
        // slide window
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + array[i + k - 1] - array[i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.print(Arrays.toString(WindowSum2.getSum(array, 4)));
    }
}