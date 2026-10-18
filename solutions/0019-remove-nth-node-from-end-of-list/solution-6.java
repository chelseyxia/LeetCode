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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinal = new ListNode(0);
        sentinal.next = head;
        ListNode fast = sentinal;
        ListNode slow = sentinal;
        int i = 0;
        while(i < n){
            fast = fast.next;
            i++;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return sentinal.next;
    }
}
