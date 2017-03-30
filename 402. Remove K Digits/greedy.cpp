class Solution {
public:
	string removeKdigits(string num, int k)
	{
		int digits = num.size() - k;
		string stk;

		for (int i = 0; i < num.size(); i++)
		{
			char c = num[i];
			while (stk.size() > 0 && k > 0 && stk.back() > c)
			{
				k--;
				stk.pop_back();
			}
			stk.push_back(c);
		}
		stk.resize(digits);
		while (stk.size() > 0 && stk.front() == '0') { stk.erase(0, 1); }
		return (stk.empty() ? "0" : stk);
	}
}
