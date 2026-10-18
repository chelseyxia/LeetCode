class Solution {
    //dfs, use seen array and stack
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //firstly, we add all the adjacent node of each node into a nested arraylist
        //then, we create a boolean array and fill with all false
        //thirdly, we create a stack and push source into the stack
        ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjacent.add(new ArrayList<>());
        }
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);
        Stack<Integer> stack = new Stack();
        for(int[] edge : edges){
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        stack.push(source);
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(temp == destination){
                return true;
            }
            if(seen[temp]){
                continue;
            }
            seen[temp] = true;
            for(int i = 0; i < adjacent.get(temp).size(); i++){
                stack.push(adjacent.get(temp).get(i));
            }
        }
        return false;
    }
}
