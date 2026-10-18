class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int stone : stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if(b != a){
                int temp = Math.abs(b - a);
                maxHeap.add(temp);
            }
        }
        if(maxHeap.size() == 0){
            return 0;
        }
        return maxHeap.poll();
    }
}
