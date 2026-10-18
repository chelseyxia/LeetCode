class Solution {
    public int minTransfers(int[][] transactions) {
        // 0 -> 1: 10       1 own 0: 10
        // 2 -> 0: 5        0 own 2: 5
        //0-1: 10
        //1-0: 1 -> 1 own 0: 9
        //1-2: 5 -> 2 own 1: 5
        //2-0: 5 -> 0 own 2: 5
        Map<Integer, Integer> map = new HashMap();
        for(int[] t : transactions){
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
        }
        
        List<Integer> list = new ArrayList();
        
        for(int v : map.values()){
            if(v != 0)
                list.add(v);
        }
        return dfs(0, list);
    }
    
    private int dfs(int i, List<Integer> list){
        if(i == list.size()){
            return 0;
        }
        int cur = list.get(i);
        if(cur == 0){
            return dfs(i + 1, list);
        }
        int min = Integer.MAX_VALUE;
        for(int j = i + 1; j < list.size(); j++){
            int next = list.get(j);
            if(cur * next < 0){
                list.set(j, cur + next);
                min = Math.min(min, 1 + dfs(i + 1, list));
                list.set(j, next);
                if(cur + next == 0){
                    break;
                }
            }
        }
        return min;
    }
}
