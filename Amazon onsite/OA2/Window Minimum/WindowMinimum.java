import java.util.*;
public class WindowMinimum {
    public static int[] minSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) 
                deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) 
                deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2, 12, 11, -5};
        System.out.print(Arrays.toString(WindowMinimum.minSlidingWindow(nums, 2)));
    }
}