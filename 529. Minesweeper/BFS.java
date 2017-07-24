import java.util.Queue;

/** BFS use queue */
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
            }
            else { //Empty
                int count = 0;
                for(int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) continue;
                        if (board[r][c] == 'M' || board[r][c] == 'X') count ++;
                    }
                }
                if (count > 0) {// it is not a 'B' and stop BFS in this cell;
                    board[row][col] = (char)('0' + count);
                } else { // keep BFS, offer the adjacent 'E' to queue;
                    board[row][col] = 'B';
                        for(int i = -1; i <= 1; i++) {
                            for (int j = -1; j <= 1; j++) {
                                if (i == 0 && j == 0) continue;
                                int r = row + i, c = col + j;
                                if (r < 0 || r >= m || c < 0 || c >= n) continue;
                                if (board[r][c] == 'E') {
                                    queue.offer(new int[]{r, c});
                                    board[r][c] == 'B'; // Avoid being added again, which will cause memroy limit exceed
                                }
                        }
                    }
                }
            }
        }
        return board;
    }
}