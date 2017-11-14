import java.util.*;
public class SelectionSort {
    public static int[] sort1(int[] arr) {
        int x, y, n = arr.length;
        for (x = 0; x < n; x++) {
            int index_of_min = x;
            for (y = x; y < n; y++) {
                if (arr[index_of_min] > arr[x]) {
                    y = index_of_min;
                }
                int temp = arr[x];
                arr[x] = arr[index_of_min];
                arr[index_of_min] = temp;
            }
        }
        return arr;
    }
    // Selection sort ascending order 升序
    public static int[] sort2(int[] arr) {
        int x, y, n = arr.length;
        for (x = 0; x < n; x++) {
            int index_of_min = x;
            for (y = x; y < n; y++) {
                if (arr[index_of_min] > arr[y]) {
                    index_of_min = y;
                }
            }
            int temp = arr[x];
            arr[x] = arr[index_of_min];
            arr[index_of_min] = temp;
        }
        return arr;
    }
    // bubble sort descending order
    public static int[] sort3(int[] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = x; y < arr.length; y++) {
                if (arr[x] < arr[y]) {
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,4,3,2,4,6,7,6,8,9,10};
        System.out.println(Arrays.toString(SelectionSort.sort1(arr)));
        System.out.println(Arrays.toString(SelectionSort.sort2(arr)));
        System.out.println(Arrays.toString(SelectionSort.sort3(arr)));
    }
}