public class ShortArray {
    public static int[] removeElement(int[] arr, int index) {
        int i, j, len = arr.length;
        if (index < len) {
            for (i = index; i < len - 1; i++) {
                arr[i] = arr[i + 1];
            }
            int rarr[] = new int[len - 1];
            for (i = 0; i < len-1; i++) {
                rarr[i] = arr[i];
            }
            return rarr;
        } else {
            return arr;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6};
        int[] rarr = ShortArray.removeElement(arr, 3);
        for ( int i = 0; i < rarr.length; i++) {
            System.out.print(rarr[i] + " ");
        }
    }
}