<<<<<<< HEAD
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        need, missing = collections.Counter(t), len(t)
        i = I = J = 0
        #enumerate还可以接收第二个参数，用于指定索引起始值
        for j, c in enumerate(s, 1):
            missing -= need[c] > 0
            need[c] -= 1
            if missing == 0:
                while i < j and need[s[i]] < 0:
                    need[s[i]] += 1
                    i += 1
                if J == 0 or j - i < J - I:
                    I, J = i, j
        return s[I: J]

=======
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        need, missing = collections.Counter(t), len(t)
        i = I = J = 0
        #enumerate还可以接收第二个参数，用于指定索引起始值
        for j, c in enumerate(s, 1):
            missing -= need[c] > 0
            need[c] -= 1
            if missing == 0:
                while i < j and need[s[i]] < 0:
                    need[s[i]] += 1
                    i += 1
                if J == 0 or j - i < J - I:
                    I, J = i, j
        return s[I: J]

>>>>>>> origin/master
The current window is s[i:j] and the result window is s[I:J]. In need[c] I store how many times I need character c (can be negative) and missing tells how many characters are still missing. In the loop, first add the new character to the window. Then, if nothing is missing, remove as much as possible from the window start and then update the result.