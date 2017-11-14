import java.util.Map;
import java.util.HashMap;
public class TwoSum {
    public static int TwoSumCount(int[] nums, int target) {
        if (nums == null || nums.length < 2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                count += map.get(target - num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,7,3,3,3,3,3,3,4,5,6};
        System.out.print(TwoSum.TwoSumCount(nums, 10));
    }
}