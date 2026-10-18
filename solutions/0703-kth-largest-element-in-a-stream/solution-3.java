class KthLargest {
    PriorityQueue<Integer> minHeap;
    int key;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.key = k;
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < key){
            minHeap.offer(val);
        }
        else if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
