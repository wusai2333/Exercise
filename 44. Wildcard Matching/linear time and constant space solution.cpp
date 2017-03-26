class Solution {
public:
	bool isMatch(string s, string p)
	{
		int i = 0, j = 0, star = -1, ss;
		int n = s.size(), m = p.size();

		while (i < n)
		{
			// advancing both index when (both characters match) or ('?' found in pattern)
			// note that j will not advance beyond its length;
			if ((j < m) && ((p[j] == s[i]) || (p[j] == '?'))) { i++; j++; continue; }

			// '*' found in pattern, track index of '*', only advancing the pattern pointer
			if ((j < m) && (p[j] == '*')) { star == j++; ss = i; continue; }

			// current characters do not match, last pattern pointer was '*', current pattern pointer is not '*'
			// only advancing the pattern pointer
			if (star >= 0) { j = star + 1; i = ++ss; continue; }

			// current pointer is not '*'   , last pointer was not star
			// characters do not match
			return (false);
		}
		// checking for remaining characters in pattern
		while (j < m && p[j] == '*') { j++; }
		return (j == m);
	}
}
