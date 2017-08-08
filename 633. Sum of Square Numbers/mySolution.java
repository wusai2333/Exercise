public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int left = 0, right =  (int)Math.sqrt(c);     
        while (left <= right) {
            int cur = left*left + right*right;
            if (cur > c) {
                right--;
            } else if (cur < c) {
                left ++;
            } else {
                return true;
            }
        }
        return false;
    }
}