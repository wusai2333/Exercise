class Solution {
public:
	int findMinArrowShots(vector<pair<int, int> >& points)
	{
		int count = 0, arrowLimit = INT_MAX;

		sort(points.begin(), points.end(), mysort);
		for (int i = 0; i < points.size(); i++)
		{
			if ((arrowLimit != INT_MAX) && (points[i].first <= arrowLimit)) { continue; }
			arrowLimit = points[i].second;
			count++;
		}
		return (count);
	}


	static bool mysort(pair<int, int>& a, pair<int, int>& b)
	{
		return (a.second == b.second ? a.first < b.first : a.second < b.second);
	}
};
