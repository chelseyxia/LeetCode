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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = new ListNode(-1, head);
        ListNode curr = prev.next;
        ListNode tail = null;
        int i = 0;
        while(i != right){
            if(i < left - 1){
                prev = curr;
                curr = curr.next;
            }
            else if(i == left - 1){
                tail = curr;
                curr = curr.next;
            }
            else{
                tail.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                curr = tail.next;
            }
            i++;
        }
        return left == 1 ? prev.next : head;
    }
}
