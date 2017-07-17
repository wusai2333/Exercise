def subset(self, nums):
    res = []
    self.dfs(nums, 0, [], res)
    return res

def dfs(self, nums, index, path, res):
    res.append(path)
    for i in range(index, len(nums)):
        self.dfs(nums, i+1, path+[nums[i]], res)