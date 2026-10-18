class MedianFinder {
    PriorityQueue<Integer> l;
    PriorityQueue<Integer> r;
    public MedianFinder() {
        l = new PriorityQueue<>((a, b) -> b - a);
        r = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        int lsize = l.size();
        int rsize = r.size();
        if(lsize == rsize){
            if(r.isEmpty() || num <= r.peek()){
                l.add(num);
            }
            else{
                l.add(r.poll());
                r.add(num);
            }
        }
        
        else{
            if(l.peek() <= num){
                r.add(num);
            }
            else{
                r.add(l.poll());
                l.add(num);
            }
        }
    }
    
    public double findMedian() {
        int lsize = l.size();
        int rsize = r.size();
        if(lsize == rsize){
            return (l.peek() + r.peek()) / 2.0;
        }
        else{
            return l.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
