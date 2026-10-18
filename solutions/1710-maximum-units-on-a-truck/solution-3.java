class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for(int[] boxType : boxTypes){
            int boxCount = Math.min(boxType[0], truckSize);
            ans += boxType[1] * boxCount;
            truckSize -= boxCount;
            if(truckSize == 0){
                break;
            }
        }        
        return ans;
    }
}
