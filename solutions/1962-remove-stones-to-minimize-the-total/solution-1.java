class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int res = 0;
        for(int pile : piles){
            maxHeap.offer(pile);
        }
        while(k != 0 && !maxHeap.isEmpty()){
            int candidate = maxHeap.poll();
            int floor = candidate / 2;
            //res += candidate - floor;
            k--;
            maxHeap.offer(candidate - floor);
        }
        while(k == 0 && !maxHeap.isEmpty()){
            res += maxHeap.poll();
        }
        return res;
    }
}
