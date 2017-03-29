class Solution {
public:
	string rearrangeString(string s, int k)
	{
		if (k <= 1) { return (s); }
		int length = (int)s.size();
		string res;
		unordered_map<char, int> dict; //if key is not presented, default value is bool false;
		priority_queue<pair<int, char> > pq;

		for (char ch : s) { dict[ch]++; }
		for (auto it = dict.begin(); it != dict.end(); it++)
		{
			pq.push(make_pair(it->second, it->first));
		}

		while (!pq.empty())
		{
			vector<pair<int, char> > cache; //store used char during one while loop
			int count = min(k, length);     //count: how many steps in a while loop
			for (int i = 0; i < count; i++)
			{
				if (pq.empty()) { return (""); }
				auto tmp = pq.top();
				pq.pop();
				res.push_back(tmp.second);
				if (--tmp.first > 0) { cache.push_back(tmp); }
				length--;
			}
			for (auto c: cache) { pq.push(c); }
		}
		return (res);
	}
};
