class Solution {
public:
	vector<pair<int, int> > reconstructQueue(vector<pair<int, int> >& people)
	{
		auto compare = [](pair<int, int>& p1, pair<int, int>& p2)
		    { return p1.first > p2.first || (p1.first == p2.first && p1.second < p2.second) };

		sort(people.begin(), people.end(), compare);
		for (auto& p : people)
		{
			res.insert(res.begin() + p.second, p);
		}
		return (res);
	}
}
