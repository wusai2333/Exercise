import java.util.Arrays;
public class Search2DMatrix {
    public static int[] isInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return new int[]{-1, -1};
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c > 0) {
            if (matrix[r][c] == target) 
                return new int[]{r, c};
            if (matrix[r][c] > target)
                c--;
            else
                r++;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {3,4,5,6},
            {7,8,9,10}
        };
        System.out.print(Arrays.toString(Search2DMatrix.isInMatrix(matrix, 1)));
    }
}