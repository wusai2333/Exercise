public class Solution {
	public int jump(int[] nums)
	{
		int sc = 0;
		int e = 0;
		int max = 0;

		for (int i = 0; i < num.length - 1; i++)
		{
			max = Math.max(max, nums[i] + i);
			if (i == e) {
				sc++;
				e = max;
			}
			if (e >= num.length - 1) {
				return (sc);
			}
		}
		return (sc);
	}
}
