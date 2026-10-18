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
        ListNode save = head, low = head, high = head, prev = head;
        for(int i = 0; i < n; i++){
            high = high.next;
        }
        if(high == null){
            return save.next;
        }
        while(high != null){
            prev = low;
            low = low.next;
            high = high.next;
        }
        prev.next = low.next;
        return save;
    }
}
