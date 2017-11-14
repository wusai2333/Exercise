
import java.util.*;
public class CacheMiss{
    public static int solution(int[] array, int size) {
        if (array == null) return 0;
        List<Integer> cache = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < array.length; i ++) {
            if (cache.contains(array[i])) {
                cache.remove(new Integer(array[i]));
            } else {
                count ++;
                if (size == cache.size()) {
                    cache.remove(0);
                }
            }
            cache.add(array[i]);
        }
        return count;
    }

    public static int count(int[] arr, int size) {
        if (arr == null || arr.length == 0 || size <= 0) return 0;
        List<Integer> cache = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cache.contains(arr[i])) {
                cache.remove(new Integer(arr[i]));
            } else {
                count ++;
                if (size == cache.size()) {
                    cache.remove(0);
                }
            }
            cache.add(arr[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,1,2,3};
        System.out.print(CacheMiss.count(array, 4));
    }
}