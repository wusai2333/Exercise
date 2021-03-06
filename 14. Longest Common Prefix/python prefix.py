class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs: 
            return ""
        
        pre = strs[0]
        for i in range(1, len(strs)):
            while strs[i].find(pre) != 0:
                pre = pre[:-1]
        return pre

            