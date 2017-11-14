class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int i = 0;
        int length = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        while (i <= length) {
            int h = (i == length) ? 0: heights[i];
            if (stack.empty() || heights[stack.peek()] <= h) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int sidx = stack.empty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, heights[top] * (i - sidx - 1));
            }
        }
        return maxArea;
    }
}

// http://www.geeksforgeeks.org/largest-rectangle-under-histogram/