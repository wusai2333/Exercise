public class ArithmeticSlice {
    public static int countArithmeticSlice(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int count = 0, diff = nums[1] - nums[0], length = 2;
        int result = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int curDiff = nums[i+1] - nums[i];
            if (curDiff == diff) length++;
            else {
                diff = curDiff;
                if (length >= 3) {
                    result += (1 + length -2) * (length -2) / 2;
                }
                if (result > 1000000000) return -1;
                length = 2;
            }
        }
        if (length >= 3) {
            result += (1 + length - 2) * (length - 2) / 2;
        }
        return result > 1000000000 ? -1 : result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,4,7,10,12,14,16};
        System.out.print(ArithmeticSlice.countArithmeticSlice(nums));
    }
}