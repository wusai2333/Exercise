class LRUCache(object):
    def __init__(self, capacity):
        self.deque = collections.deque()
        self.dic = {}
        self.capacity = capacity

    def get(self, key):
        if key not in self.dic:
            return -1
        self.deque.remove(key)
        # Warning remove in deque takes O(n) time
        self.deque.append(key)
        return self.dic[key]

    def put(self, key, value):
        if key in self.dic:
            self.deque.remove(key)
        elif len(self.dic) == self.capacity:
            v = self.deque.popleft()
            self.dic.pop(v)
        self.deque.append(v)
        self.dic[key] = value
