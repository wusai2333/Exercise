import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.empty() && stack.peek() < num) 
                nextGreater.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = nextGreater.getOrDefault(findNums[i], -1);
        }
        return findNums;
    }
}