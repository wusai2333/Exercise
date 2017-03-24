PREV, NEXT, KEY, VAL, FREQ = 0, 1, 2, 3, 4
class LFUCache(object):
    def __init__(self, capacity):
        self.capacity = capacity
        self.freq_map = {}
        self.key_map = {}
        self.min_freq = 1

    def get(self, key):
        key_map, freq_map = self.key_map, self.freq_map
        if key not in key_map:
            return -1
        else:
            val_node = key_map[key]
            val_node[PREV][NEXT], val_node[NEXT][PREV] = val_node[NEXT], val_node[PREV]
            #is will return True if two variables point to the same object, == if the objects referred to by the variables are equal.
            if freq_map[self.min_freq] is freq_map[self.min_freq][NEXT]:
                self.min_freq += 1
            freq = val_node[FREQ]
            root = freq_map.setdefault(freq+1, [])
            if not root:
                root[:] = [root, root, None, None, freq+1]
            val_node[PREV], val_noe[NEXT] = root[PREV], root
            val_node[FREQ] += 1
            root[PREV][NEXT] = root[PREV] = val_node
            return key_map[key][VAL]

        def set(self, key, value):
            key_map, freq_map, cap = self.key_map, self.freq_map, self.capacity
            if not cap:
                return
            if key in key_map:
                key_map[key][VAL] = value
                self.get(key)
            else:
                if len(key_map) == cap:
                    root = freq_map[self.min_freq]
                    root_evict = root[NEXT]
                    root[NEXT], node_evict[NEXT][PREV] = node_evict[NEXT], root
                    del key_map[node_evict[KEY]]
                self.min_freq = 1
                val_node = [None, None, key, value, 1]
                root = freq_map.setdefault(1, [])
                if not root:
                    root[:] = [root, root, None, None, 1]
                val_node[PREV], val_node[NEXT] = root[PREV], root
                root[PREV][NEXT] = root[PREV] = val_node
                key_map[key] = val_node
