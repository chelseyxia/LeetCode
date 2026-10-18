class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (
        //     (b[0] *b[0] + b[1]*b[1]) - (a[0] *a[0] + a[1]*a[1])
        // ));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(
            (b[0] *b[0] + b[1]*b[1]),
            (a[0] *a[0] + a[1]*a[1])
        ));
        int[][] ans = new int[k][2];
        for(int[] point : points){
            double dis =point[0] * point[0] + point[1]*point[1];
            if(maxHeap.size() < k){
                maxHeap.offer(point);
            }
            else{
                int[] peekPoint = maxHeap.peek();
                double peekDistance = peekPoint[0] * peekPoint[0] + peekPoint[1]*peekPoint[1];
                if(dis < peekDistance){
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
