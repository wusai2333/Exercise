class Solution {
public:
	bool isSubsequence(string s, string t)
	{
		string::iterator i = s.begin();
		string::iterator j = t.begin();

/*		while (*j)
 *              {
 *                      i += (*i == *j++);
 *              }*/
		for (auto c : t) { i += (*i == c); }
		return (i == s.end());
	}
};

// For the Follow-up, assume we have S1...Sk,
// above C++ code can be change to a simple follow-up version:
class Solution {
public:
	vector<bool> isSubsequence(vector<string> ss, string t)
	{
		vector<string::const_iterator> iters(ss.size());
		for (int i = 0; i < ss.size(); i++)
		{
			iters[i] = ss[i].begin();
		}

		for (char c: t)
		{
			for (int i = 0; i < ss.size(); i++)
			{
				iters[i] += (*iters[i] == c);
			}
		}

		vector<bool> ans(ss.size());
		for (int i = 0; i < ss.size(); i++)
		{
			ans[i] = iters[i] == ss[i].end();
		}
		return (ans);
	}
};

// Follow-up Faster, O(len(t) + sum(len(s[i])))
class Solution {
public:
	vector<bool> isSubsequence(vector<string> ss, string t)
	{
		vector<string::const_iterator> iters(ss.size());
		vector<vector<int> > waitingList(26);
		for (int i = 0; i < ss.size(); i++)
		{
			iters[i] = ss[i].begin();
			waitingList[*iters[i] - 'a'].push_back(i);
		}
		for (char c : t)
		{
			vector<int> updateList = waitingList[c - 'a'];
			waitingList[c - 'a'].clear();
			for (int i : updateList)
			{
				iters[i]++;
				waitingList[*iters[i] - 'a'].push_back(i);
			}
		}
		vector<bool> ans(ss.size());
		for (int i = 0; i < ss.size(); i++)
		{
			ans[i] = iters[i] == ss[i].end();
		}
		return (ans);
	}
};
