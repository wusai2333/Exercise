public class ArrayOperation {
    public static int[] replaceValues(int[] arr) {
        int i, j, len = arr.length;
        if (len % 2 ==0 ){
            for (i = 0 ; i < len; i++) { // "<=" -> "<";
                arr[i] = 0;
            }
        } else {
            for (j = 0; j < len; j++) {
                arr[j] = 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int[] arr2 = new int[]{1,2,3,4,5};
        ArrayOperation.replaceValues(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}