class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (
            (b[0] *b[0] + b[1]*b[1]) - (a[0] *a[0] + a[1]*a[1])
        ));
        int[][] ans = new int[k][2];
        for(int[] point : points){
            double dis = Math.sqrt(point[0] * point[0] + point[1]*point[1]);
            if(maxHeap.size() < k){
                maxHeap.offer(point);
            }
            else{
                int[] peakPoint = maxHeap.peek();
                double peakVal = Math.sqrt(peakPoint[0] * peakPoint[0] + peakPoint[1]*peakPoint[1]);
                if(dis < peakVal){
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }
        for(int i = 0; i < k; i++){
            int[] point = maxHeap.poll();
            ans[i] = new int[]{point[0], point[1]};
        }
        return ans;
    }
}
