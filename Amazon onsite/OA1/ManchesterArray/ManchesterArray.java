import java.util.*;
public class ManchesterArray {
    public static int[] check(int[] arr) {
        int[] result = new int[arr.length];
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                result[0] = arr[0] != 0 ? 1 : 0;
            } else {
                flag = arr[i] != arr[i-1];
                result[i] = flag ? 1 : 0;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,2,3,4,3,3};
        System.out.print(Arrays.toString(ManchesterArray.check(arr)));
    }
}