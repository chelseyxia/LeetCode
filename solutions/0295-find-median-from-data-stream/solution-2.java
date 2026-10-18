class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    double result;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        if(!minHeap.isEmpty() && num > minHeap.peek()){
            minHeap.offer(num);
            if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }
        else{
            maxHeap.offer(num);
            if((maxHeap.size() - minHeap.size()) >= 2){
                minHeap.offer(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if((minHeap.size() + maxHeap.size()) % 2 != 0){
            result = maxHeap.peek();
        }
        else{
            result = (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
