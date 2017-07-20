import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<Pair<Integer, Integer>> pairs = new LinkedList<Pair<Integer, Integer>>();
    public void setZeroes (int[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    pairs.add(new Pair<Integer,Integer>(i,  j));
                }
            }
        }
        for (Pair p : pairs) {
            int row = p.first;
            int col = p.second;
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
         
    }

    private class Pair<K, V> {
        public  K first;
        public  V second;
        public Pair(K first, V second) {
            this.first(first);
            this.second(second);
        }
    }
}