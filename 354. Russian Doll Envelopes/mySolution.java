// O(N^2) not a good answer
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // O(nlogn) time best answer with DP and binary search; 用了300.longest increasing subsequence 做法。
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                return arr1[0] - arr2[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] env: envelopes) {
            int i = 0, j = len, mid;
            while (i < j) {
                mid = (i + j) >> 1;
                if (dp[mid] < env[1]) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            dp[i] = env[1];
            if (i == len) len++;
        }
        return len;
    }

}