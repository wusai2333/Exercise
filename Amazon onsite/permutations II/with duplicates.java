// First of all, the conclusion is both !use[i - 1] and use[i - 1] work, but the !use[i - 1] is more efficient.

// Here goes the explanation:
// If we use
// if(i > 0 && nums[i] == nums[i - 1] && use[i - 1]) continue;
// Chances are that we have the same value,and we will never have chance to use the second one, which causes the list will never grow to the length of nums.length, and waste exists.
// Here we have an example of the simple [1, 2, 2']. We start at list = [], and in the first level of backtrack, we have:
// [1]
// [2]
// [2']
// In the second level, when list = [1], ve:
// [1, 2]
// [1, 2']
// When list = [2], when i = 0 we have [2, 1] without difficulty, when i = 1, "2" is already used so we simply continue. But when i = 2, we found that nums[2] = nums[1] and nums[1] is already used, so we discard it and the list is still [1]. The problem is that when we have to figure out the next element of this track, we will find that the "2'" will never be used because nums[2] == nums[1] && used(nums[1]) is always true. This track will never reach the recursive base and be added to the final answer.

// If we use
// if(i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) continue;
// When we figure out the first element of the list,when i = 2 we find that nums[2] == nums[1] true and used(nums[1]) false, so we directly skip the list starting with "2'", and we get
// [1] and
// [2]
// only. The same rule continues on the next steps so every list we generated will reach to an end and return.

// That why !use[i - 1] is better. Hope that my explanation is clear enough.

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backTrace(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    
    void backTrace(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            list.add(nums[i]);
            backTrace(nums, res, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}