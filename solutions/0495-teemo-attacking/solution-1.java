class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int ans = 0;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return duration;
        }
        List<int[]> list = new ArrayList();
        int[] t = new int[2];
        t[0] = timeSeries[0];
        t[1] = timeSeries[0] + duration - 1;
        list.add(t);
        for(int i = 1; i < n; i++){
            int a = timeSeries[i];
            int b = timeSeries[i] + duration - 1;
            if(list.get(list.size() - 1)[1] < a){
                int[] temp = new int[2];
                temp[0] = a;
                temp[1] = b;
                list.add(temp);
            }
            else{
                list.get(list.size() - 1)[0] = Math.min(list.get(list.size() - 1)[0], a);
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], b);
            }
        }
        for(int i = 0; i < list.size(); i++){
            ans += list.get(i)[1] - list.get(i)[0] + 1;
        }
        return ans;
    }
}
