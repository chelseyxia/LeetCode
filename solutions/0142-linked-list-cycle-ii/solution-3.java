/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        if(head == null || head.next == null){
            return null;
        }
        ListNode curr = head;
        while(curr != null){
            if(set.contains(curr)){
                return curr;
            }
            else{
                set.add(curr);
                curr = curr.next;
            }
        }
        return null;
    }
}
