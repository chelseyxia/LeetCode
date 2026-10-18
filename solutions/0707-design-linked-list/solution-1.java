class MyLinkedList {
    //here we should call LinkedNode and do initialization
    ListNode head;
    int size;
    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode curr = head;
        for(int i = 0; i < index + 1; i++){
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        ++size;
        ListNode prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        ListNode temp = new ListNode(val);
        temp.next = prev.next;
        prev.next = temp;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){
            return;
        }
        ListNode prev = head;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
