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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for(int i = 0; i < lists.length; i++){
            ans = mergeTwoLists(ans, lists[i]);
        } 
        return ans;
    }
    public ListNode mergeTwoLists(ListNode ans, ListNode list){
        if(ans == null || list == null){
            return ans != null ? ans : list;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(ans != null && list != null){
            if(ans.val <= list.val){
                tail.next = ans;
                ans = ans.next;
            }
            else{
                tail.next = list;
                list = list.next;
            }
            tail = tail.next;
        }
        tail.next = ans != null ? ans : list;
        return head.next;
    }
}
