import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public int findLonelyPixel(char[][] picture) {
        Map<Integer,Integer> rowMap = new HashMap<Integer, Integer>();
        Map<Integer,Integer> colMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    if (rowMap.containsKey(i)) {
                        rowMap.put(i, rowMap.get(i)+1);
                    } else {
                        rowMap.put(i, 1);
                    }
                    if (colMap.containsKey(j)) {
                        colMap.put(j, colMap.get(j)+1);
                    } else {
                        colMap.put(j, 1);
                    }
                }
            }
        }
        int row = 0;
        int col = 0;
        for(Map.Entry<Integer, Integer> entry: rowMap.entrySet()) {
            if (entry.getValue() == 1) {
                row ++;
            }
        }
        for (Map.Entry<Integer, Integer> entry: colMap.entrySet()) {
            if (entry.getValue() == 1) {
                col ++;
            }
        }
        return Math.min(row, col);
    }
}