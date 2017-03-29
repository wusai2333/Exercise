class Solution(object):
    def rearrangeString(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        if len(s) <= 1:
            return s
        count = collections.defaultdict(int)
        valid = collections.defaultdict(int)
        for c in s:
            count[c] += 1
        res = []
        for index in range(len(s)):
            candidate = self.findValidMax(count, valid, index)
            if candidate == "":
                return ""
            count[candidate] -= 1
            valid[candidate] = index + k
            res.append(candidate)
        return ''.join(res)

    def findValidMax(self, count, valid, index):
        Max = -sys.maxsize
        candidate = ""
        for c, v in count.items():
            if v > 0 and v > Max and index >= valid[c]:
                Max = v
                candidate = c
        return candidate
