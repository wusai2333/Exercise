public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 ==0) return false;
        int reversedRightHalf = 0;
        while (reversedRightHalf < x) {
            int tail = x % 10;
            reversedRightHalf = reversedRightHalf * 10 + tail;
            x = x / 10;
        }
        return reversedRightHalf == x || reversedRightHalf/10 == x;
    }
}