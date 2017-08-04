public class Solution {
    public int mySqrt(int x) {
        /** return (int)Math.sqrt(x);*/
        /** Binary Search */
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (mid == 0) return x; // x == 1;
            if (mid > x/mid) right = mid - 1;
            else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
        return left; // x == 0;
    }
}