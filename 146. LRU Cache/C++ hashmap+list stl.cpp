class LRUCache {
    size_t m_capacity;
    unordered_map<int, list<pair<int, int>>::iterator> m_map;
    list<pair<int, int>> m_list;

public:
    LRUCache(int capacity):m_capacity(capacity) {
    }
    int get(int key) {
        auto found_iter = m_map.find(key);
        if (found_iter == m_map.end()) return -1;
        m_list.splice(m_list.begin(), m_list, found_iter->second);
        return found_iter->second->second;
    }
    void put(int key, int value) {
        auto found_iter = m_map.find(key);
        //key exists
        if (found_iter != m_map.end()) {
            m_list.splice(m_list.begin(), m_list, found_iter->second);
                //move the corresponding key to the front
            found_iter->second->second = value; //update value of the node
            return;
        }
        if (m_map.size() == m_capacity) {
            int key_to_del = m_list.back().first;
            m_list.popback(); // remove node in list;
            m_map.erase(key_to_del); //remove key in map;
        }
        m_list.emplace_front(key, value); //create new node in list
        m_map[key] = m_list.begin(); //create correspondence between key and node
    }
}
