import java.util.Arrays;
public class RotateMatrix {
    public static int[][] Solution (int[][] matrix, int flag) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        int[][] result = transpose(matrix);
        flip(result, flag);
        return result;
    }

    private static int[][] transpose (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    private static void flip (int[][] matrix, int flag) {
        int m = matrix.length, n = matrix[0].length;
        if (flag == 1) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n / 2; j++) {
                    matrix[i][j] ^= matrix[i][n - j - 1];
                    matrix[i][n - j - 1] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[i][n - j - 1];
                }
            }
        } else {
            for (int i = 0; i < m / 2; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] ^= matrix[m - i - 1][j];
                    matrix[m - i - 1][j] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[m - i - 1][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}};
        int[][] result = RotateMatrix.Solution(matrix, 1);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}