public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;
        Stack<String> stack = new Stack<>();
        String[] nodes = preorder.split(",");
        for (int pos = 0; pos < nodes.length; pos++) {
            String cur = nodes[pos];
            while (cur.equals("#") && !stack.empty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(cur);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}