<<<<<<< HEAD
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> tmp(1000);
        vector<int> ans;
        
        if(nums1.empty() || nums2.empty()) {
            return vector<int>();
        }
        for(int i = 0; i <nums1.size();i++ )
            tmp[nums1[i]] = 1;
        for(int i = 0; i<nums2.size(); i++) {
            if(tmp[nums2[i]] == 1) {
                ans.push_back(nums2[i]);
                tmp[nums2[i]] = 0;
            }
        }
        return ans;
    }
=======
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> tmp(1000);
        vector<int> ans;
        
        if(nums1.empty() || nums2.empty()) {
            return vector<int>();
        }
        for(int i = 0; i <nums1.size();i++ )
            tmp[nums1[i]] = 1;
        for(int i = 0; i<nums2.size(); i++) {
            if(tmp[nums2[i]] == 1) {
                ans.push_back(nums2[i]);
                tmp[nums2[i]] = 0;
            }
        }
        return ans;
    }
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
};