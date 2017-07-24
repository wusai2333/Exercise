/** I cannot  solve this problem */
/** it is a DFS solution */
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        int m = board.length, n = board[0].length;
        if (board[row][col] == 'M') { //Mine
            board[row][col] = 'X';
        } else { // Empty
            // get the number of the mines first;
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i==0 && j==0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') count ++;
                }
            }
            if (count > 0) { // if it is not a 'B' stop further DFS
                board[row][col] = (char)(count + '0');
            } else { // If it is a 'B' we continue DFS to adjacent cells
                board[row][col] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[]{r, c});
                    }
                }
            }
        }
        return board;
    }
}