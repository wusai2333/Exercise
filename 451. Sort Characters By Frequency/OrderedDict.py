class Solution:
    def frequencySort(self, s):
        if not s:
            return ""
        dic = collections.defaultdict(int)
        for c in s:
            dic[c] += 1
        sorted_dic = collections.OrderedDict(sorted(dic.items(), key = lambda x: -x[1]))
        ans = ""
        for k, v in sorted_dic.items():
            for i in range(v):
               ans += k
        return ans 