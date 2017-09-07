class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int upper = 0, right = n - 1, lower = n - 1, left = 0;
        int num = 1;
        while (upper <= lower && left <= right) {
            for (int i = left;upper <= lower && i <= right; i++) {
                res[upper][i] = num++;
            }
            upper ++;
            for (int i = upper; right >= left && i <= lower; i++) {
                res[i][right] = num++;
            }
            right --;
            for (int i = right; lower >= upper && i >= left; i--) {
                res[lower][i] = num++;
            }
            lower --;
            for (int i = lower; right >= left && i >= upper; i--) {
                res[i][left] = num++;
            }
            left ++;
        }
        return res;
    }
}