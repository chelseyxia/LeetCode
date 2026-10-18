class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int currentMax = Integer.MIN_VALUE;
        int[] minimumRange = new int[2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->{
            int valueA = nums.get(a[0]).get(a[1]);
            int valueB = nums.get(b[0]).get(b[1]);
            return Integer.compare(valueA, valueB);
        });
        for(int i = 0; i < nums.size(); i++){
            currentMax = Math.max(currentMax, nums.get(i).get(0)); 
            minHeap.offer(new int[]{i, 0});
        }
        int[] curIndex = minHeap.peek();
        minimumRange[0] = nums.get(curIndex[0]).get(curIndex[1]);
        minimumRange[1] = currentMax;
        while(minHeap.size() == nums.size()){
            int[] indexes = minHeap.poll();
            int curRange = currentMax - nums.get(indexes[0]).get(indexes[1]);
            if(curRange < (minimumRange[1] - minimumRange[0])){
                minimumRange[0] = nums.get(indexes[0]).get(indexes[1]);
                minimumRange[1] = currentMax;
            }
            if((indexes[1]+1) < nums.get(indexes[0]).size()){
                minHeap.offer(new int[]{indexes[0], indexes[1] + 1});
                currentMax = Math.max(currentMax, nums.get(indexes[0]).get(indexes[1] + 1));
            }
        }
        return minimumRange;
    }
}
