class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> arraylist = new ArrayList<>(map.entrySet());
        Collections.sort(arraylist, (o1, o2) -> o1.getValue().equals(o2.getValue()) ? (o2.getKey() - o1.getKey()) : (o1.getValue().compareTo(o2.getValue())));
        
        int[] res = new int[nums.length];
        int z = 0;
        
        for(int i = 0; i < arraylist.size(); i++){
            for(int j = 0; j < arraylist.get(i).getValue(); j++){
                res[z++] = arraylist.get(i).getKey();
            }
        }
        
        return res;
    }
}
