public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] a = moves.toCharArray();
        for (char c: a) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'L') {
                x--;
            } else if (c == 'R'){
                x++;
            }
        }
        return x==0 && y==0;
    }
}