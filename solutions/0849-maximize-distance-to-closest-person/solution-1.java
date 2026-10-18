class Solution {
    public int maxDistToClosest(int[] seats) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = seats.length;
        int i = 0, j = 1;
        for(j = 1; j < n; j++){
            if(seats[j] == 0 && j < n - 1){
                continue;
            }
            else if(seats[j] == 1){
                if(seats[i] == 0){
                    int tempDis = j - i;
                    if(!map.containsKey(tempDis)){
                        map.put(tempDis, new ArrayList<Integer>());
                    }
                    map.get(tempDis).add(i);
                }
                else if(seats[i] == 1){
                    int tempDis = (j - i) / 2;
                    if(!map.containsKey(tempDis)){
                        map.put(tempDis, new ArrayList<Integer>());
                    }
                    map.get(tempDis).add((j - i)/ 2 + i);                    
                }
                i = j;
            }
            if(seats[j] == 0 && j == n - 1){
                int tempDis = j - i;
                if(!map.containsKey(tempDis)){
                    map.put(tempDis, new ArrayList<Integer>());
                }
                map.get(tempDis).add(j);                
            }
            //1000000; 0000001; 100100000; 000001001; 00100000
        }
        int res = -1;
        for(int key : map.keySet()){
            res = Math.max(res, key);
        }
        return res;
    }
}
