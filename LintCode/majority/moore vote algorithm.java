// O(1) space O(n) time
class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        int count = 0, candidate = -1;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}