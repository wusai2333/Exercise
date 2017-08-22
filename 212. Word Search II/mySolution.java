// Failed
class Solution {
    private List<String> result = new ArrayList<>();
    private static final int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null||board.length == 0 || board[0].length == 0) return result;
        if (words == null || words.length == 0) return result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backTrack(board, words, i, j, new int[words.length], new boolean[words.length]);
            }
        }
        return result;
    }

    private void backTrack(char[][] board, String[] words, int i, int j, int[] starts, boolean[] visited) {
        for (int p = 0; p < words.length; p++) {
            if (!visited[p] && starts[p] == words[p].length()) {
                result.add(words[p]);
                visited[p] = true;
            }
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char temp = board[i][j];
        board[i][j] = '1';
        for (int p = 0; p < words.length; p++) {
            if (!visited[p] && words[p].charAt(starts[p]) == temp) {
                starts[p]++;
                for (int[] dir: dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    backTrack(board, words, x, y, starts, visited);
                }
            }
        }
        board[i][j] = temp;
    }
}