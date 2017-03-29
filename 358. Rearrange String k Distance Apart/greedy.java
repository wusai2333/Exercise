public class Solution {
	public String rearrangeString(String s, int k)
	{
		int length = s.length();

		int[] count = new int[26];
		int[] valid = new int[26];
		for (int i = 0; i < length; i++)
		{
			count[s.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < length; index++)
		{
			int candidatePos = findValidMax(count, valid, index);
			if (candidatePos == -1) { return (""); }
			count[candidatePos]--;
			valid[candidatePos] = index + k;
			sb.append((char)('a' + candidatePos));
		}
		return (sb.toString());
	}


	private int findValidMax(int[] count, int[] valid, int index)
	{
		int max = Integer.MIN_VALUE;
		int candidatePos = -1;

		for (int c = 0; c < 26; c++)
		{
			if ((count[c] > 0) && (index >= valid[c]) && (count[c] > max)) {
				max = count[c];
				candidatePos = c;
			}
		}
		return (candidatePos);
	}
}
