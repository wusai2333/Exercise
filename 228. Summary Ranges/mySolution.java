class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0, end = 0;
        List<String> res = new ArrayList<>();
        while (start < nums.length) {
            while (end < nums.length - 1 && nums[end+1] == nums[end] + 1) {
                end ++;
            }
            if (start == end) {
                res.add(String.valueOf(nums[start]));
            } else {
                res.add(nums[start] + "->" + nums[end]);
            }
            start = end + 1;
            end = start;
        }
        return res;
    }
}