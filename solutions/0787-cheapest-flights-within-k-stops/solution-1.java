class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] adjMatrix = new int[n][n];
        for(int[] flight : flights){
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }
        int[] distances = new int[n];
        int[] currStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currStops[src] = 0;
        PriorityQueue<int[]> minheap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minheap.offer(new int[]{src, 0, 0});
        while(!minheap.isEmpty()){
            int[] info = minheap.poll();
            int node = info[0];
            int stops = info[2];
            int cost = info[1];
            if(node == dst){
                return cost;
            }
            if(stops == k + 1){
                continue;
            }
            for(int nei = 0; nei < n; nei++){
                if(adjMatrix[node][nei] > 0){
                    int dU = cost;
                    int dV = distances[nei];
                    int wUV = adjMatrix[node][nei];
                    if(dU + wUV < dV){
                        minheap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    }
                    else if(stops < currStops[nei]){
                        minheap.offer(new int[]{nei, dU + wUV, stops + 1});
                    }
                    currStops[nei] = stops;
                }
            }
        }
        
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}
