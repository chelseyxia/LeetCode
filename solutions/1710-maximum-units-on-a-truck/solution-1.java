class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
     //(5,10) + (3,9) + (2,7) = 91
        int unitCount = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        //Arrays.sort(myArr, (a, b) -> Double.compare(a[0], b[0]));
        for(int[] boxType : boxTypes){
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            if(truckSize == 0){
                break;
            }
        }
        return unitCount;
    }
}
