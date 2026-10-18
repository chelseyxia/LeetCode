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
        if(head == null){
            return null;
        }
        ListNode curr = head;
        Set<ListNode> set = new HashSet();
        while(curr.next != null){
            if(!set.contains(curr)){
                set.add(curr);
                curr = curr.next;
            }
            else{
                return curr;
            }
        }
        return null;
    }
}
