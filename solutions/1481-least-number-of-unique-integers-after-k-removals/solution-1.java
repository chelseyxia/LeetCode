class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        List<int[]> freq = new ArrayList();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int[] keyValue = {entry.getKey(), entry.getValue()};
            freq.add(keyValue);
        }
        
        Collections.sort(freq, new Comparator<int[]>(){
            public int compare(int[] keyValue1, int[] keyValue2){
                return keyValue1[1] - keyValue2[1];
            }
        });
        
        int ans = freq.size();
        for(int i = 0; i < freq.size(); i++){
            int occ = freq.get(i)[1];
            if(k >= occ){
                --ans;
                k -= occ;
            }
            else{
                break;
            }
        }        
        return ans;
    }
}
