class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int cost = 0;
        if(sticks.length == 1){
            return 0;
        }
        for(int stick : sticks){
            minHeap.offer(stick);
        }
        while(minHeap.size() >= 2){
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            cost += min1 + min2;
            if(minHeap.isEmpty()){
                return cost;
            }
            minHeap.offer(min1 + min2);
        }
        return 0;
    }
}
