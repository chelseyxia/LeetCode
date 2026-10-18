/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    
    class WrappableInt{
        private Integer value;
        public WrappableInt(Integer x){
            this.value = x;
        }
        public Integer getValue(){
            return this.value;
        }
        public void increment(){
            this.value++;
        }
    }
    
    class DeserializeObject extends HashMap<Integer, Pair<Integer, Pair<Integer, Node>>>{}
    
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        ser_helper(root, sb, new WrappableInt(1), null);
        return sb.toString();
    }
    
    public void ser_helper(Node root, StringBuilder sb, WrappableInt identity, Integer parentId){
        if(root == null){
            return;
        }
        sb.append((char)(identity.getValue() + '0'));
        sb.append((char)(root.val + '0'));
        sb.append((char)(parentId == null ? 'N' : parentId + '0'));
        parentId = identity.getValue();
        for(Node child : root.children){
            identity.increment();
            ser_helper(child, sb, identity, parentId);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        return des_helper(data);
    }
    private Node des_helper(String data){
        DeserializeObject nodesAndParents = new DeserializeObject();
        for(int i = 0; i < data.length(); i+=3){
            int id = data.charAt(i) - '0';
            int orgValue = data.charAt(i + 1) - '0';
            int parentId = data.charAt(i + 2) - '0';
            Pair<Integer, Pair<Integer, Node>> node = new Pair<Integer, Pair<Integer, Node>>(orgValue, new Pair<Integer, Node>(parentId, new Node(orgValue, new ArrayList<Node>())));
            nodesAndParents.put(id, node);
        }
        
        for(int i = 3; i < data.length(); i+=3){
            int id = data.charAt(i) - '0';
            Node node = nodesAndParents.get(id).getValue().getValue();
            int parentId = data.charAt(i + 2) - '0';
            Node parentNode = nodesAndParents.get(parentId).getValue().getValue();
            parentNode.children.add(node);
        }
        return nodesAndParents.get(data.charAt(0) - '0').getValue().getValue();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
