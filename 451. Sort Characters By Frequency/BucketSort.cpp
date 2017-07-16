class Solution {
public:
    string freqeucySort(string s) {
        unordered_map<char, int> freq;
        vector<string> bucket(s.size()+1, "");
        string res;
        for (char c: s) {
            freq[c] ++;
        }
        for (auto& it: freq) {
            char c = it.first;
            int n = it.second;
            bucket[n].append(n, c);
        }
        for (int i = s.size(); i > 0; i--) {
            res.append(bucket[i]);
        }
        return res;
    }
}