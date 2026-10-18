class MyHashMap {
    private class Pair{
        private int key;
        private int value;
        public Pair(int k, int v){
            this.key = k;
            this.value = v;
        }
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
        public void setKey(int k){
            this.key = k;
        }
        public void setVlaue(int v){
            this.value = v;
        }
    }
    private static final int BASE = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for(int i = 0; i < BASE; ++i){
            data[i] = new LinkedList<Pair>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                pair.setVlaue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Pair pair = iterator.next();
            if(pair.getKey() == key){
                return pair.value;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Pair  pair = iterator.next();
            if(pair.key == key){
                data[h].remove(pair);
                return;
            }
        }
    }
    
    private static int hash(int key){
        return key % BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
