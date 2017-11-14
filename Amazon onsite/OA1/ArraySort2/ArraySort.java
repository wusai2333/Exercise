import java.util.*;
public class ArraySort {
    public static int[] sortArray(int[] arr) {
        int len = arr.length;
        int small, pos, i, j,temp;
        for (i = 0; i <= len-1; i++) {
            for (j = i; j < len; j++) {
                temp = 0;
                if (arr[i] < arr[j]) { // '>' -> '<'
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{123,34,25,341,535,1212};
        arr = ArraySort.sortArray(arr);
        for (int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}