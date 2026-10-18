class Node{
    int key;
    int val;
    //because we want to use hashmap
    Node prev;
    Node next;
    //we need to find the least recently used key
    public Node(int key){
        this.key = key;//we can by the key to find the value, so we don't need initialize value
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        head = new Node(-1);
        tail = new Node(10001);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        moveToHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            moveToHead(n);
            return;
        }
        if(map.size() >= capacity){
            Node last = removeFromTail();
            map.remove(last.key);
        }
        Node n = new Node(key);
        n.val = value;
        addToHead(n);
        map.put(key, n);
    }
    
    Node removeFromTail(){
        Node last = tail.prev;
        removeNode(last);
        return last;
    }
    
    void moveToHead(Node n){
        removeNode(n);
        addToHead(n);
    }
    
    void removeNode(Node n){
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }
    
    void addToHead(Node n){
        Node next = head.next;
        next.prev = n;
        head.next = n;
        n.prev = head;
        n.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
