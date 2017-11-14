import java.util.*;
class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache (int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}
public class LinkedHashMapLRUCache {
    public static int countMiss(int[] array, int size) {
        LRUCache cache = new LRUCache(size);
        int count = 0;
        for (int num: array) {
            int value = cache.get(num);
            if (value == -1) count++;
            cache.set(num, 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,4,1};
        System.out.print(LinkedHashMapLRUCache.countMiss(array, 4));
    }
}