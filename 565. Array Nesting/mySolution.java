
public class Solution {

    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (visited[i]) continue;
            max = Math.max(max, helper(nums, i, visited));
        }
        return max;
    }

    private int helper(int[] nums, int start, boolean[] visited) {
        int count = 0;
        int i = start;
        while (count == 0 || i != start) {
            visited[i] = true;
            i = nums[i];
            count ++;
        }
        return count;
    }
}