class SnapshotArray {
    List<TreeMap<Integer, Integer>> list = new ArrayList<>();
    int snap;
    public SnapshotArray(int length) {
        for(int i = 0; i < length; i++){
            list.add(new TreeMap<>());
        }
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> tm = list.get(index);
        tm.put(snap, val);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> tm = list.get(index);
        Integer key = tm.floorKey(snap_id);
        return key == null ? 0 : tm.get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
