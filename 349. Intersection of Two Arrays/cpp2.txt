<<<<<<< HEAD
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {

        
        unordered_set<int> m(nums1.begin(), nums1.end());
        vector<int> res;
        for (auto a: nums2) {
            if (m.count(a)){
                res.push_back(a);
                m.erase(a);
            }
        }
        return res;
    }
=======
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {

        
        unordered_set<int> m(nums1.begin(), nums1.end());
        vector<int> res;
        for (auto a: nums2) {
            if (m.count(a)){
                res.push_back(a);
                m.erase(a);
            }
        }
        return res;
    }
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
};