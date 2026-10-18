/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }   
        ListNode prevA = headA;
        ListNode prevB = headB;
        Set<ListNode> set = new HashSet<ListNode>();
        while(prevA != null){
            set.add(prevA);
            prevA = prevA.next;
        }
        while(prevB != null){
            if(set.contains(prevB)){
                return prevB;
            }
            prevB = prevB.next;
        }        
        return null;
    }
}
