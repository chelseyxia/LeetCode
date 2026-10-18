class MovingAverage {
    List<Integer> q;
    int size;
    public MovingAverage(int size) {
        q = new ArrayList();
        this.size = size;
    }
    
    public double next(int val) {
        q.add(val);
        int windowSum = 0;
        for(int i = Math.max(0, q.size() - size); i < q.size(); i++){
            windowSum += q.get(i);
        }
        return windowSum * 1.0 / (Math.min(q.size(), size));
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
