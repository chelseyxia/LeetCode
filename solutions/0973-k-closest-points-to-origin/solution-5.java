class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]>maxPQ = new PriorityQueue<>((a, b) -> b[0] -a[0]);
        for(int i = 0; i < points.length; i++){
            int[] entry = {squareDistance(points[i]), i};
            if(maxPQ.size() < k){
                maxPQ.add(entry);
            }
            else if(entry[0] < maxPQ.peek()[0]){
                maxPQ.poll();
                maxPQ.add(entry);
            }
        }
        int[][] answers = new int[k][2];
        for(int i = 0; i < k; i++){
            int entryIndex = maxPQ.poll()[1];
            answers[i] = points[entryIndex];
        }
        return answers;
    }
    
    private int squareDistance(int[] points){
        return points[0] * points[0] + points[1] * points[1];
    }
}
