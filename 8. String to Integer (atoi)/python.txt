class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        s= str.strip()
        sign, base, cnt = 1, 0, 0
        for i in range(len(s)):
            cur = s[i]
            if cur == '+' or cur == '-':
                sign = 1 - 2 * bool(cur == '-')
                cnt += 1
            elif cur.isdigit():
                base = base * 10 + ord(cur) - ord('0')
            elif cur.isalpha() or cur == ' ':
                break
            if cnt > 1:
                return 0
        return max(min(base*sign, 2147483647), -2147483648)
        