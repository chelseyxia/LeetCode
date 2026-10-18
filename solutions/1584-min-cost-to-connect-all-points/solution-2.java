class Solution {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        int[] point = points[0];
        int a = point[0];
        int b = point[1];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((x, y) -> x.cost - y.cost);
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);
        for(int i = 1; i < size; i++){
            int cost = Math.abs(points[i][0] - a) + Math.abs(points[i][1] - b);
            Edge edge = new Edge(0, i, cost);
            pq.offer(edge);
        }
        visited[0] = true;
        int ans = 0;
        int count = size - 1;
        
        while(!pq.isEmpty() && count > 0){
            Edge edge = pq.poll();
            int point1 = edge.start;
            int point2 = edge.end;
            int cost = edge.cost;
            if(!visited[point2]){
                ans += cost;
                visited[point2] = true;
                for(int j = 0; j < size; j++){
                    if(!visited[j]){
                        int cc = Math.abs(points[point2][0] - points[j][0]) + Math.abs(points[point2][1] - points[j][1]);
                        pq.add(new Edge(point2, j, cc));                      
                    }
                }
                count--;
            }
        }
        return ans;
    }
}

class Edge{
    int start, end, cost;
    public Edge(int s, int e, int c){
        this.start = s;
        this.end = e;
        this.cost = c;
    }
}
