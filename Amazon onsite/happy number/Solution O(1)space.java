class Solution {
    public int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int m = n % 10;
            n /= 10;
            sum += m * m;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1) return true;
        else return false;
    }
}