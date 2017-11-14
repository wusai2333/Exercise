import java.util.Arrays;
public class FourInteger {
    public static int[] Solution(int A, int B, int C, int D) {
        int[] result = new int[4];
        result[0] = A;
        result[1] = B;
        result[2] = C;
        result[3] = D;
        Arrays.sort(result);
        exch(result, 0, 1);
        exch(result, 2, 3);
        exch(result, 0, 3);
        return result;
    }
    private static void exch(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(FourInteger.Solution(1,2,3,4)));
    }
}