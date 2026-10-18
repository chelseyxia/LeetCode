class Solution {
    public int lastStoneWeight(int[] stones) {
        //Pattern: Repeatedly extract the current maximum. or Dynamic Candidate Set + Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size() >= 2){
            int firstMaxStone = maxHeap.poll();
            int secondMaxStone = maxHeap.poll();
            int newWeight = firstMaxStone - secondMaxStone;
            if(newWeight != 0){
                maxHeap.offer(newWeight);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
