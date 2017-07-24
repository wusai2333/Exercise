public class Solution {
    public int reverse(int x) {
        String f = String.valueOf(x);
        int sign = 0;
        if (x < 0) {
            f = f.replace("-", "");
            sign = 1;
        }
        StringBuilder sb = new StringBuilder(f);
        sb = sb.reverse();
        if (sign == 1) {
            sb.insert(0, '-');
        }
        try {
            int re = Integer.parseInt(sb.toString());
            return re; 
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}