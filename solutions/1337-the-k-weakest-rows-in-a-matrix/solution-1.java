class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[k];
        for(int i = 0; i < n; i++){
            int cnt = 0;
            int j = 0;
            while(j < m){
                if(mat[i][j] == 1){
                    cnt++;
                    j++;
                }
                else if(mat[i][j] == 0){
                    break;
                }
            }
            if(!map.containsKey(cnt)){
                map.put(cnt, new ArrayList<>());
            }
            map.get(cnt).add(i);
        }
        
        int i = 0;
        List<Integer> sortedMap = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortedMap);
        for(int key : sortedMap){
            for(int index : map.get(key)){
                ans[i] = index;
                i++;
                if(i == k){
                    break;
                }
            }
            if(i == k){
                break;
            }
        }
        return ans;
    }
}
