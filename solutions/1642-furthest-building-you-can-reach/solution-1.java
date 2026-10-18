class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for(int i = 0; i < heights.length - 1; i++){
            int temp = heights[i + 1] - heights[i];
            if(temp <= 0){
                continue;
            }
            minHeap.add(temp);
            if(minHeap.size() <= ladders){
                continue;
            }
            bricks = bricks - minHeap.poll();
            if(bricks < 0){
                return i;
            }
        }
        return heights.length - 1;
    }
}
