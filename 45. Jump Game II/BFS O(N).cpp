class Solution {
public:
	int jump(vector<int>& nums)
	{
		if (nums.size() < 2) { return (0); }
		int level = 0, currentMax = 0, i = 0, nextMax = 0;

		while (currentMax - i + 1 > 0) // nodes count of currentlevel is greater than 0
		{
			level++;
			for ( ; i <= currentMax; i++) // traverse currentlevel and update the maxreach of the next level
			{
				nextMax = max(nextMax, nums[i]+i);
				if (nextMax >= nums.size() - 1) { // if last element is in level+1, then the min jump = level
					return (level);
				}
			}
			currentMax = nextMax;
		}
		return (0);
	}
};
