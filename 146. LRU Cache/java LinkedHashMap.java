<<<<<<< HEAD
import java.util.LinkedHashMap;
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private LRUCache(int capacity) {
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
    public void put(int key, int value) {
        map.put(key, value);
    }
}
//Several points to mention:
/**
In the constructor, the third boolean parameter specifies
the ordering mode. If we set it to true, it will be in access order.
 (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-in
 t-float-boolean-)
By overriding removeEldestEntry in this way, we do not need to t
ake care of it ourselves. It will automatically remove t
he least recent one when the size of map exceeds the
specified capacity.
(https://docs.oracle.com/javase/8/docs/api/java/util/
LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-)
**/
=======
import java.util.LinkedHashMap;
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private LRUCache(int capacity) {
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
    public void put(int key, int value) {
        map.put(key, value);
    }
}
//Several points to mention:
/**
In the constructor, the third boolean parameter specifies
the ordering mode. If we set it to true, it will be in access order.
 (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-in
 t-float-boolean-)
By overriding removeEldestEntry in this way, we do not need to t
ake care of it ourselves. It will automatically remove t
he least recent one when the size of map exceeds the
specified capacity.
(https://docs.oracle.com/javase/8/docs/api/java/util/
LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-)
**/
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
