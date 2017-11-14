import java.util.Arrays;
public class RotateMatrix2 {
    public static int[][] rotate(int[][] matrix, int flag) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] right = new int[cols][rows];
        int[][] left = new int[cols][rows];

        if (flag == 1) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    right[j][rows - 1 - i] = matrix[i][j];
                }
            }
            return right;
        } else if (flag == 0) {x    
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    left[cols - 1 - j][i] = matrix[i][j];
                }
            }
            return left;
        }
        return null;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}};
        int[][] result = RotateMatrix2.rotate(matrix, 1);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    
}