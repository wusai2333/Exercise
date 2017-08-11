public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums.length == 0 || nums == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> used = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]+k)) {
                if (!used.contains(nums[i])) {
                    count++;
                    used.add(nums[i]);
                }
            }
            if (map.containsKey(nums[i]-k)) {
                if (!used.contains(nums[i]-k)) {
                    count ++;
                    used.add(nums[i]-k);
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return count;
    }
}