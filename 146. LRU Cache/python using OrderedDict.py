class LRUCache(object):
    def __init__(self, capacity):
        self.dic = collections.OrderedDict()
        self.remain = capacity

    def get(self, key):
        if key not in self.dic:
            return -1
        v = self.dic.pop(key)
        self.dic[key] = v
        # If a new entry overwrites an existing entry,
        #   Insertion position is left unchanged.
        #   Deleting an entry and reinserting it will
        # move it to the end
        return v

    def put(self, key, value):
        if key in self.dic:
            self.dic.pop(key)
        else:
            if self.remain > 0:
                self.remain -= 1
            else: # self.dic is full
                self.dic.popitem(last=False)
        self.dic[key] = value
