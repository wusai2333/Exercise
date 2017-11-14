public class NumArray{
    int[] tree;
    public NumArray(int[] nums) {
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j <= nums.length) {
                tree[j] += nums[i];
                j += LastOneBit(j);
            }
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j+1) - getSum(i);
    }

    private int getSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= LastOneBit(i);
        }
        return sum;
    }
    private int LastOneBit(int j) {
        return j & (-j);
    }
}