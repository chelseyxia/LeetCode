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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if(cur1.val <= cur2.val){
            cur1.next = mergeTwoLists(cur1.next, cur2);
            return cur1;
        }
        if(cur1.val > cur2.val){
            cur2.next = mergeTwoLists(cur1, cur2.next);
            return cur2;
        }
        return null;
    }
}
