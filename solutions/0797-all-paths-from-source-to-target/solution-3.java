class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPath = new ArrayList<>();
        //bfs: while loop + queue 
        //dag: no boolean visited
        //queue: LinkedList
        if(graph.length == 0 || graph == null){
            return allPath;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.add(path);
        
        while(!queue.isEmpty()){
            List<Integer> p = queue.poll();
            int node = p.get(p.size() - 1);
            /*if(graph[node].length == 0){
                allPath.add(p);
            }
            for(int n : graph[node]){
                p.add(n);
                queue.add(p);
                p.remove(p.size() - 1);
            }*/
            /*List<Integer> tmpPath = new ArrayList<>(currentPath);
                tmpPath.add(nextNode);
                if (nextNode == graph.length - 1) {
                    paths.add(new ArrayList<>(tmpPath));
                } else {
                    queue.add(new ArrayList<>(tmpPath));
                } */
            for(int n : graph[node]){
                List<Integer> temp = new ArrayList<>(p);
                temp.add(n);
                if(n ==graph.length - 1){
                    allPath.add(new ArrayList<>(temp));
                }
                else{
                    queue.add(new ArrayList<>(temp));
                }
                
            }
        }
        return allPath;
    }
}
