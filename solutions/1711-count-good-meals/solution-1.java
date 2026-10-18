class Solution {
    public int countPairs(int[] deliciousness) {
        //==2 -> different food items
        //power of 2
        //items with different indices are considered different even if they have the same deliciousness value.
        long result = 0;
        //store them to a map
        //the funtion to computer power of 2
        //count how many and add to the result
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : deliciousness){
            map.merge(n, 1, Integer::sum);
        }
        for(int key : map.keySet()){
            int i = 1;
            int current = map.get(key);
            while(key > i - key){
                i <<= 1;
            }
            while(i <= (1 << 21)){
                result += (key != i - key ?
                    1L * current * map.getOrDefault(i - key, 0) :
                    (1L * current * (current - 1)) / 2);
                i <<= 1;
            }
        }
        return (int)(result%(int)(1e9+7));
    }
}
