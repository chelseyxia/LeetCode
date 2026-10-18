class Solution {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int x = entry.getKey();
            int val = entry.getValue();
            if(k > 0 && map.containsKey(k + x)){
                result++;
            }
            else if(k == 0 && val > 1){
                result++;
            }
        }
        
        return result;
    }
}
