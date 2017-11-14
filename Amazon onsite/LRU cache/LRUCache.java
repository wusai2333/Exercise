import java.util.HashMap;

class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode next;
        DLinkedNode prev;
    }
    
    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * Remove an existing node from the linkedlist
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.prev;
        DLinkedNode nxt = node.next;

        pre.next = nxt;
        nxt.prev = pre;
    }

    /**
     * Move a certain node in between to head
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * pop the current tail;
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        this.removeNode(res);
        return res;
    }

    private DLinkedNode head, tail;
    private int count;
    private int capacity;
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.prev = null;
        tail = new DLinkedNode();
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // move the accessed Node to the head;
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            while (count > capacity) {
                // pop the tail;
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value;
            node.value = value;
            this.moveToHead(node);
        }
    }
}
