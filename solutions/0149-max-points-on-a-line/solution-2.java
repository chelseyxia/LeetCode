class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ret = 0;
        if(n <= 2){
            return n;
        }
        for(int i = 0; i < n; i++){
            if(ret >= n - i || ret > n / 2){
                break;
            }
            Map<Integer, Integer> map = new HashMap();
            
            for(int j = i + 1; j< n; j++){
                int[] y = points[j];
                int nx = points[i][0] - points[j][0];
                int ny = points[i][1] - points[j][1];
                if(nx == 0){
                    ny = 1;
                }
                else if(ny == 0){
                    nx = 1;
                }
                else{
                    if(ny < 0){
                        nx = -nx;
                        ny = -ny;
                    }
                    int gcdXY = gcd(Math.abs(nx), Math.abs(ny));
                    nx /= gcdXY;
                    ny /= gcdXY;
                } 
                int key = ny + nx * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }
    public int gcd(int a, int b){
        return b != 0 ? gcd(b, a % b) : a;
    }
}
