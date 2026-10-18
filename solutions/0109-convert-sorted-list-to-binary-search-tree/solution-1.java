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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        int size = listsize(head);
        this.head = head;
        return convertToBST(0, size - 1);
    }
    public int listsize(ListNode head){
        int c = 0;
        while(head != null){
            head = head.next;
            c++;
        }
        return c;
    }
    public TreeNode convertToBST(int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = convertToBST(l, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        root.right = convertToBST(mid + 1, r);
            
        return root;
    }
}
