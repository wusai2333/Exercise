public class MaximumMinimumPath {
    public static int solution(int[][] matrix) {
        int[] result = new int[matrix[0].length];
        result[0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            result[i] = Math.min(result[i - 1], matrix[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            result[0] = Math.min(result[0], matrix[i][0]);
            for (int j = 1; j < matrix[0].length; j++) {
                result[j] = (result[j - 1] < matrix[i][j] && result[j] < matrix[i][j]) ? Math.max(result[j - 1], result[j]) : matrix[i][j];
            }
        }
        return result[result.length - 1];
    }

    public static int maxMinPath (int[][] matrix) {
        int[] result = new int[matrix[0].length];
        result[0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            result[i] = Math.min(result[i - 1], matrix[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            result[0] = Math.min(result[0], matrix[i][0]);
            for (int j = 1; j < matrix[0].length; j++) {
                result[j] = (result[j - 1] < matrix[i][j] && result[j] < matrix[i][j]) ? Math.max(result[j - 1], result[j]) : matrix[i][j];
            }
        }
        return result[result.length - 1];
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {8, 4, 7},
            {6, 5, 9}
        };
        System.out.println(MaximumMinimumPath.solution(matrix));
        System.out.print(MaximumMinimumPath.maxMinPath(matrix));
    }
}