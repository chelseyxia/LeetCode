class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Set<Integer> set = new HashSet();
        for(int key : map.keySet()){
            if(!set.contains(map.get(key))){
                set.add(map.get(key));
            }
            else{
                return false;
            }
        }
        return true;
    }
}
