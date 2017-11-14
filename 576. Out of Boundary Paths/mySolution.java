class Solution {
    public int findPaths(int m , int n, int N, int i, int j) {
        long[][][] dp = new long[N+1][m][n];
        for (int Ni = 1; Ni <= N; Ni++) {
            for (int mi = 0; mi < m; mi++) {
                for (int ni = 0; ni < n; ni++) {
                    dp[Ni][mi][ni] = ((mi == 0 ? 1 : dp[Ni-1][mi-1][ni]) + (mi == m - 1? 1 : dp[Ni-1][mi+1][ni]) + (ni == 0? 1: dp[Ni-1][mi][ni-1]) + (ni == n-1 ? 1 : dp[Ni-1][mi][ni+1])) % 1000000007;
                }
            }
        }
        return dp[N][i][j];
    }

    // 2. less space consume O(2 * m * n)
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] dp = new long[2][m][n];
        for (int Ni = 1; Ni <= N; Ni++) {
            int nc = Ni % 2, np = (Ni + 1) % 2;
            for (int mi = 0; mi < m; mi++) {
                for (int ni = 0; ni < n; ni++) {
                    dp[nc][mi][ni] = ((mi == 0 ? 1 : dp[np][mi-1][ni]) + (mi == m - 1? 1 : dp[np][mi+1][ni]) + (ni == 0? 1: dp[np][mi][ni-1]) + (ni == n-1 ? 1 : dp[np][mi][ni+1])) % 1000000007;
                }
            }
        }
        return (int)dp[N % 2][i][j]; 
    }

    // 3. less less space consume O(m * (n + 1));
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][] dp = new long[m][n];
        long[] r = new long[n];
        for (int Ni = 1; Ni <= N; Ni++) {
            for (int mi = 0; mi <= m; mi++) {
                for (int ni = 0; ni < n; ni++) {
                    long temp = r[ni];
                    r[l] = ((mi == 0 ? 1 : dp[mi-1][ni]) + (mi == m - 1? 1 : dp[mi+1][ni]) + (ni == 0? 1: dp[mi][ni-1]) + (ni == n-1 ? 1 : dp[mi][ni+1])) % 1000000007;
                    if (mi > 0)
                        dp[mi-1][ni] = temp;
                }
            }
        }
        return (int)dp[i][j]; 
    }
}