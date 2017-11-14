public class Solution {
    public int majorityNumber(List<Integer> nums) {
        int len = nums.size();
        int count1 = 0, count2 = 0, candidate1 = nums.get(0), candidate2 = nums.get(0);
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1 --;
                count2 --;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            if (num == candidate2) count2++;
        }
        if (count1 > len / 3) return candidate1;
        if (count2 > len / 3) return candidate2;
        return 0;
    }
}