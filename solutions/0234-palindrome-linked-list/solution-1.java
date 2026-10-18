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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode cur = head;
        
        while(cur != null){
            stack.add(cur.val);
            cur = cur.next;
        }
        int[] array = new int[stack.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = stack.pop();
        }
        int l = 0, r = array.length - 1;
        while(l <= r){
            if(array[l] != array[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
