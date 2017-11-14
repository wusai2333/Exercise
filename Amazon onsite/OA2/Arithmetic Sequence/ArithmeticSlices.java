public class ArithmeticSlices {
    public static int countArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int diff = Integer.MIN_VALUE;
        int start = 0;
        int count = 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            int curDiff = nums[i] - nums[i - 1];
            if (diff == curDiff) {
                count += i - start - 1 > 0 ? i - start - 1 : 0; // i - start + 1 - 2, eg. 1 4 7 10 : when it comes to 10, add 2 slices : 1 4 7 10 and 4 7 10
            } else {
                start = i - 1;
                result += count;
                diff = curDiff;
                count = 0;
                if (result > 1000000000) return -1;
            }
        }
        result += count;
        return result <= 1000000000? result : -1;
    }

    public static int count2(int[] nums) {
        if(nums == null || nums.length < 3) return 0;
        int left = 0;
        int right = 1;
        int diff = nums[1] - nums[0];
        int count = 0;
        while (right < nums.length - 1) {
            if (diff != nums[right+1] - nums[right]) {
                count += (right - left - 1) * (right - left) / 2;
                if (count > 1000000000) return -1;
                diff = nums[right + 1] - nums[right];
                left = right;
            }
            right ++;
        }
        count += (right - left - 1) * (right - left) / 2;
        return count <= 1000000000 ? count : -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,7,10,12,14,16};
        System.out.println(ArithmeticSlices.countArithmeticSlices(nums));
        System.out.println(ArithmeticSlices.count2(nums));
    }
}