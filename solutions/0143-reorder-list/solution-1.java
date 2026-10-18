/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //deque: first, last, first, last
        Deque<Integer> dq = new LinkedList();
        ListNode newHead = head;
        ListNode curr = head;
        while(curr != null){
            dq.add(curr.val);
            curr = curr.next;
        }
        
        while(!dq.isEmpty()){
            newHead.val = dq.pollFirst();
            
            newHead = newHead.next;                

            if(dq.size() > 0){
                newHead.val = dq.pollLast();
                newHead = newHead.next;                
            }
        }
    }
}
