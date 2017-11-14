import java.util.*;
public class sortArray {
    public static int[] sortArray(int[] arr) {
        int i, max, location, j, temp, len = arr.length;
        for (i = 0; i < len; i++) {
            max = arr[i];
            location = i;
            for (j = i; j < len; j++) {
                if (max < arr[j]) { // '>'' -> '<'
                    max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{123,34,25,341,535,1212};
        arr = sortArray.sortArray(arr);
        for (int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}