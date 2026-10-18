class Node{
    public int value;
    public Node nextNode;
    
    public Node(int value){
        this.value = value;
        this.nextNode = null;
    }
}
class MyCircularQueue {
    private Node head, tail;
    private int count;
    private int capacity;
    
    public MyCircularQueue(int k) {
        this.capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(capacity == count){
            return false;
        }
        Node newNode = new Node(value);
        if(count == 0){
            head = tail = newNode;
        }
        else{
            tail.nextNode = newNode;
            tail = newNode;
        }
        count += 1;
        return true;
    }
    
    public boolean deQueue() {
        if(count == 0){
            return false;
        }
        head = head.nextNode;
        count -= 1;
        return true;
    }
    
    public int Front() {
        if(count == 0){
            return -1;
        }
        return head.value;
    }
    
    public int Rear() {
        if(count == 0){
            return -1;
        }
        return tail.value;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
