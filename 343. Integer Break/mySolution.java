import java.util.LinkedList;

class Solution {
    public int integerBreak(int n) {
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }
}