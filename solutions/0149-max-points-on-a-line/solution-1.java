class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for(int i = 0; i < n; i++){
            int[] x = points[i];
            for(int j = i + 1; j < n; j++){
                int[] y = points[j];
                int cnt = 2;
                for(int k = j + 1; k < n; k++){
                    int[] z = points[k];
                    int s1 = (y[1] - x[1]) * (z[0] - y[0]);
                    int s2 = (z[1] - y[1]) * (y[0] - x[0]);
                    if(s1 == s2){
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}

//t = (y2 - y1) / (x2 - x1)
//c = (x2 * y1 - x1 * y2) / (x2 - x1)
//y = tx + c
//用hashmap分别储存在一条线上的不同数组，数组数最多的就是答案
//key: int[] arr = new int[]{t, c};
//value: map: key: count, value: point[][]
