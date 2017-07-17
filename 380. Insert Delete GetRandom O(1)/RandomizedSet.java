import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/** Using HashMap and ArrayList for O(1) insert and remove and getRandom() */
public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    Random rand;
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
        rand = new Random();
    }

    /** Insert a value to the set. Return True if the set did not already contain the specified element */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if (contain) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) return false;
        int idx = locs.get(val);
        /** if it is not the last one then swap the lastone with this val*/
        if (idx < nums.size() - 1) {
            int lastone = nums.get(nums.size()-1);
            nums.set(idx, lastone);
            locs.put(lastone, idx);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}