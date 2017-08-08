public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        int left = 0, right = num;
        while (left < right) {
            int mid = left + (right - left)/ 2;
            System.out.println(mid);
            if (mid == 1.0*num / mid) return true;
            else if (mid> 1.0*num/mid) right = mid;
            else left = mid + 1;
        }
        return false;
    }
}