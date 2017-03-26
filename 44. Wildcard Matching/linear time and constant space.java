boolean isMatch(String s, String p)
{
	int i = 0, j = 0, ss = 0, star = -1;
	int n = s.length(), m = p.length();

	while (i < n)
	{
		// advance both pointers
		if ((j < m) && ((p.charAt(j) == s.charAt(i)) || (p.charAt(j) == '?'))) {
			i++;
			j++;
		}
		// '*' found , only advance the pattern pointer
		else if ((j < m) && (p.charAt(j) == '*')) {
			star = j;
			j++;
			ss = i;
		}
		// last pattern pointer is '*', advancing the string pointer
		else if (star >= 0) {
			ss++;
			i = ss;
			j = star + 1;
		}
		// current pattern pointer is not '*' and last pattern pointer is not '*'
		// characters don't match
		else{
			return (false);
		}
	}
	// check for remaining characters in pattern
	while (j < m && p.charAt(j))
	{
		j++;
	}
	return (j == m);
}
