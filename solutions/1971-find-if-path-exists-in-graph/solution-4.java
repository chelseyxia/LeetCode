class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);
        stack.add(source);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        //[[0,1],[1,2],[2,0]]
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(temp == destination){
                return true;
            }
            if(seen[temp]){
                continue;
            }
            seen[temp] = true;
            for(int j = 0; j < list.get(temp).size(); j++){
                stack.add(list.get(temp).get(j));
            }
        }
        return false;
    }
}
