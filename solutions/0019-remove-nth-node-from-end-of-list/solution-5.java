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
        if(head == null){
            return null;
        }
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        ListNode sentinal = new ListNode(0);
        sentinal.next = head;
        ListNode prev = sentinal;
        ListNode temp = head;
        int cnt = size - n;
        int i = 0;
        while(i != cnt){
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        return sentinal.next;
    }
}
