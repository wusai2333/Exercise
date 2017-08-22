class Solution {
    private static final int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    private boolean flag = false;
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTrack(board, w, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, char[] word, int i, int j, int start) {
        if (start == word.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (word[start] != board[i][j]) return false;
        board[i][j] ^= 256;
        boolean exist = backTrack(board, word, i-1, j, start+1)
                        || backTrack(board, word, i+1, j, start+1)
                        || backTrack(board, word, i, j-1, start+1)
                        || backTrack(board, word, i, j+1, start+1);
        board[i][j] ^= 256;
        return exist;
    }
}