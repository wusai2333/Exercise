public class SortArray {
    public static int[] reverseArray(int arr[]) {
        int i, temp, originalLen = arr.length;
        int len = originalLen;
        for (i = 0; i < originalLen/ 2; i++) {
            temp = arr[i];
            arr[i] = arr[len-1];
            arr[len-1] = temp;
            len -= 1; // += -> -=
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,2,3,4,5,6,7};
        arr = SortArray.reverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}