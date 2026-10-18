class TimeMap {
    class Node{
        String k, v;
        int t;
        Node(String key, String value, int timestamp){
            this.k = key;
            this.v = value;
            this.t = timestamp;
        }
    }
    
    
    HashMap<String, List<Node>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Node> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Node(key, value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.getOrDefault(key, new ArrayList<>());
        if(list.isEmpty()){
            return "";
        }
        int n = list.size();
        int l = 0, r = n - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(list.get(mid).t <= timestamp){
                l = mid;
            }
            else{
                r = mid - 1;
            }   
        }
        return list.get(r).t <= timestamp ? list.get(r).v : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
