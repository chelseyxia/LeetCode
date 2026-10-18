/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = ser_helper(root, new StringBuilder());
        return res.toString();
    }
    
    public StringBuilder ser_helper(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = ser_helper(root.left, str);
        str = ser_helper(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str_word = data.split(",");
        List<String> list_word = new LinkedList<String>(Arrays.asList(str_word));
        return des_helper(list_word);
    }
    
    public TreeNode des_helper(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode ans = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        ans.left = des_helper(list);
        ans.right = des_helper(list);
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
