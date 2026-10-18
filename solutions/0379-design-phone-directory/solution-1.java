class PhoneDirectory {
    boolean[] bool;
    PriorityQueue<Integer> pq;
    public PhoneDirectory(int maxNumbers) {
        bool = new boolean[maxNumbers];
        pq = new PriorityQueue();
        for(int i = 0; i < maxNumbers; i++){
            pq.add(i);
        }
    }
    public int get() {
        if(pq.isEmpty()){
            return -1;
        }
        int number = pq.poll();
        bool[number] = true;
        return number;
    }
    public boolean check(int number) {
        if(bool[number]){
            return false;
        }
        return true;
    }
    public void release(int number) {
        if(bool[number]){
            bool[number] = false;
            pq.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
