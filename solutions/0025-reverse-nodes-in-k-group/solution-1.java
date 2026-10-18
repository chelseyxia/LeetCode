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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode ptr = head;
        
        while(size < k && ptr != null){
            ptr = ptr.next;
            size++;
        }
        if(size == k){
            ListNode reversedHead = recursion(head, k);
            head.next = reverseKGroup(ptr, k);
            return reversedHead;
        }
        
        return head;
    }
    
    public ListNode recursion(ListNode head, int k){
        //we need a new head and return as answer
        ListNode newHead = null;
        ListNode ptr = head;
        
        while(k > 0){
            ListNode next = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = next;
            k--;
        }
        return newHead;
    }
}
