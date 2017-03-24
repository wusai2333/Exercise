class LRUCache {
public:
  LRUCache(int capacity):capacity(_capacity) {
    //构造函数后面冒号初始化数据成员
    //In C++, an underscore usually indicates a privagte member varicalbe.
  }

  int get(int key) {
    auto it = cache.find(key);
    if (it == cache.end()) return -1;
    touch(it);
    return it->second.first;
  }

  void put(int key, int value) {
    auto it = cache.find(key);
    if (it != cache.end()) touch(it);
    else {
      if (cache.size() == _capacity) {
        cache.erase(used.back());
        used.pop_back();
      }
      used.push_front(key);
    }
    cache[key] = {value, used.begin()};
  }

private:
  typedef list<int> LI;//list on Integers
  typedef pair<int, LI::iterator> PII; // pairs of Integer and Integer;
  typedef unordered_map<int, PII> HIPII; // hashtable of Integer to pair of Integer and Integer;

  void touch(HIPII::iterator it) {
    int key = it->first;
    used.erase(it->second.second);
    used.push_front(key);
    it->second.second = used.begin();
  }
  LI used;
  HIPII cache;
  int _capacity;

}
