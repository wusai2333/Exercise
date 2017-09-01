class Solution {
    public int findIntegers(int num) {
        int count = 0;
        for (int i = 0; i <= num; i++) {
            if (!isConsecutive(i)) count++;
        }
        return count;
    }

    private boolean isConsecutive(int num) {
        int prev = -1;
        int remainder;
        while (num >= 1) {
            remainder = number % 2;
            if (remainder == prev) return false;
            num >>= 1;
            prev = remainder;
        }
        return false;
    }
}