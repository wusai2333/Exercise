class Solution {
    public int calculate(String s) {
        if (s.length() == 0) return 0;
        s = "(" + s + ")";
        int[] p = {0};
        return eval(s, p);
    }

    private int eval(String s, int[] p) {
        int val = 0;
        int i = p[0];
        int sign = 1;
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch(c) {
                case '+':
                    val = val + sign*num;
                    num = 0;
                    sign = 1;
                    i++;
                    break;
                case '-':
                    val = val + sign*num;
                    num = 0;
                    sign = -1;
                    i++;
                    break;
                case '(':
                    p[0] = i+1;
                    val =  val + sign*eval(s, p);
                    i = p[0];
                    break;
                case ')':
                    p[0] = i+1;
                    return val + sign*num;
                case ' ':
                    i++;
                    continue;
                default:
                    num = 10*num + (int)(c - '0');
                    i++;
            }
        }
        return val;
    }
}