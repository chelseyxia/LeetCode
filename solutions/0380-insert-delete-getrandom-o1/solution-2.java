class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> dic;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.dic = new HashMap<Integer,Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(dic.containsKey(val)){
            return false;
        }
        dic.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!dic.containsKey(val)){
            return false;
        }
        int lastElement = list.get(list.size() - 1);
        int idx = dic.get(val);
        list.set(idx, lastElement);
        dic.put(lastElement, idx);
        list.remove(list.size() - 1);
        dic.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
