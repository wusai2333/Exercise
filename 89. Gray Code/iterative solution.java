import java.util.ArrayList;
import java.util.List;

// My idea is to generate the sequence iteratively. For example, when n=3, we can get the result based on n=2.
// 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). The middle two numbers only differ at their highest bit, while the rest numbers of part two are exactly symmetric of part one. It is easy to see its correctness.
// Code is simple:
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i=0; i < n; i++) {
            int size = result.size();
            for (int k = size-1; k>=0; k--) 
                result.add(result.get(k) | 1 << i);
        }
        return result;
    }
}
