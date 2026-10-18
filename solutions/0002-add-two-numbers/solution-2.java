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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = 0, n2 = 0;
            if(l1 != null){
                n1 = l1.val;                
            }
            if(l2 != null){
                n2 = l2.val;                
            }
            if(head == null){
                head = tail = new ListNode((n1 + n2 + carry) % 10);
            }
            else{
                tail.next = new ListNode((n1 + n2 + carry) % 10);
                tail = tail.next;
            }
            if(l1 != null){
                l1 = l1.next;        
            }
            if(l2 != null){
                l2 = l2.next;        
            }

            carry = (n1 + n2 + carry) / 10;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
