class Solution {
    // O(n) space
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for (int p : preorder) {
            if (p < low) return false;
            while (!path.empty() && p > path.peek()) {
                low = path.pop();
                System.out.print(low+",");
            }
            path.push(p);
        }
        return true;
    }
    // O(1) space
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int index = -1;
        for (int p : preorder) {
            if (p < low) return false;
            else {
                while (index >= 0 && p > preorder[index]) {
                    low = preorder[index--];
                }
                preorder[++index] = p;
            }           
        }
        return true;
    }
}