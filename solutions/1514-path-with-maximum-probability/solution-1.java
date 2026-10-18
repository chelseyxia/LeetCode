class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        Map<Integer, List<double[]>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            if(!map.containsKey(start)){
                map.put(start, new ArrayList<>());
            }
            map.get(start).add(new double[]{end, succProb[i]});
            if(!map.containsKey(end)){
                map.put(end, new ArrayList<>());
            }
            map.get(end).add(new double[]{start, succProb[i]});
        }
        double maxPro = 0;
        maxHeap.offer(new double[]{start_node, 1.0});
        double[] bestProb = new double[n];
        bestProb[start_node] = 1.0;
        while(!maxHeap.isEmpty()){
            double[] curMax = maxHeap.poll();
            int node = (int) curMax[0];
            double prob = curMax[1];
            if(node == end_node){
                return prob;
            }
            List<double[]> candidateList = map.get(node);
            if(candidateList == null){
                continue;
            }
            for(int i = 0; i < candidateList.size(); i++){
                double[] candidateEdge = candidateList.get(i);
                double candidateProb = candidateEdge[1] * prob;
                if(bestProb[(int) candidateEdge[0]] < candidateProb){
                    bestProb[(int) candidateEdge[0]] = candidateProb;
                    maxHeap.offer(new double[]{candidateEdge[0], candidateProb});
                }
            }
        }
        return 0.0;
    }
}
