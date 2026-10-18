class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        HashMap<Integer, List<int[]>> map = new HashMap();
        for(int[] point : points){
            int dis = point[0] * point[0] + point[1] * point[1];
            if(!map.containsKey(dis)){
                map.put(dis, new ArrayList<int[]>());
            }
            map.get(dis).add(new int[]{point[0], point[1]});
        }
        List<Integer> sortedDis = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortedDis);
        int i = 0;
        for(int key : sortedDis){
            List<int[]> temp = map.get(key);
            for(int j = 0; j < temp.size(); j++){
                if(i == k){
                    break;
                }
                ans[i] = temp.get(j);
                i++;
            }
            if(i == k){
                break;
            }
        }
        return ans;
    }
}
