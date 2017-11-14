import java.util.*;
public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        int i, n = arr.length;
        for (i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,2,3,4,5,6};
        arr = InsertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}