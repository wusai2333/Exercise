class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        if (nums.empty() || nums.size() < 2) return;
        
        int insertPos = 0; 
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) 
                nums[insertPos++] = nums[i];
        }
        while(insertPos < nums.size()) {
            nums[insertPos++] = 0;
        }
        }
};