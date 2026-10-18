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
    public ListNode deleteDuplicates(ListNode head) {
        return help(head);
    }
    private ListNode help(ListNode curr){
        if(curr == null || curr.next == null){
            return curr;
        }
        while(curr.next != null && curr.val == curr.next.val){
            curr.next = curr.next.next;
        }
        curr.next = help(curr.next);
        return curr;
    }
}
