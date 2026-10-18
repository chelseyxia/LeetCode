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
    public ListNode deleteMiddle(ListNode head) {
        ListNode sentinal = new ListNode(0);
        sentinal.next = head;
        ListNode prev = sentinal;
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        int mid = size / 2;
        ListNode temp = head;
        for(int i = 0; i < mid; i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return sentinal.next;
    }
}
