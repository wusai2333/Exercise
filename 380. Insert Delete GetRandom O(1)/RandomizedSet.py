import random
class RandomizedSet(object):
    """
    input:
    output:
    """
    def __init__(self):
        self.locs = {}
        self.nums = []

    def insert(self, val):
        if val in self.locs:
            return False
        self.nums.append(val)
        self.locs[val] = len(self.nums)-1
        return True

    def remove(self, val):
        if val not in self.locs:
            return False
        idx = self.locs[val]
        if idx < len(self.nums)-1:
            lastone = self.nums[-1]
            self.nums[idx] = lastone
            self.locs[lastone] = idx
        self.nums.pop()
        self.locs.pop(val)
        return True

    def getRandom(self):
        rand = random.randint(0, len(self.nums)-1)
        return self.nums[rand]