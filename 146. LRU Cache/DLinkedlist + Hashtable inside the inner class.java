public class LRUCache {
    private Map<Integer, DLinkedNode>();
    DLinkedNode tail = null;
    DLinkedNode head = null;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<Integer, DLinkedNode>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkedNode target = cache.get(key);
            int value = target.value;
            target.update();
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkedNode target = cache.get(key);
            target.value = value;
            target.update();
        } else {
            if (capacity == 0) {
                cache.remove(head.key);
                head.removeFromHead();
            }
            DLinkedNode newNode = new DLinkedNode(key, value);
            newNode.append();
            cache.put(key, value);
        }
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode left = null;
        DLinkedNode right = null;
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        //remove head from list and update head reference.
        private void removeFromHead() {
            // if 'this' is the only node, set both head and tail to null.
            if (tail == this) {
                tail == null;
                head == null;
            } else {
                head = this.right;
                head.left = null;
            }
        }
        private void update() {
            //no need to update if accessing the most recently used value.
            if (tail == this) return;
            else {
                // remove from current position and update nodes(if any) on both sides.
                if (this != head) {
                    this.left.right = this.right;
                } else {
                    head = this.right;
                }
                this.right.left = this.left;
                this.append();
            }
        }
        private void append() {
            //inserting the first node.
            if (tail == null) {
                head = this;
                tail = this;
                // append as tail and update tail reference.
            } else {
                this.right = null;
                this.left = tail;
                tail.right = this;
                tail = this;
            }
        }
        
    }
}
