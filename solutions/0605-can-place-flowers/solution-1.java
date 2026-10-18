class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int count = 0;
        int point = 0;
        while(point < length){
            
            if(flowerbed[point] == 0 && (point == 0 || flowerbed[point - 1] == 0) && (point == length - 1 || flowerbed[point + 1] == 0)){
                flowerbed[point] = 1;
                count += 1;
            }
            point++;
        }
        
        if(count >= n){
            return true;
        }
        
        return false;
    }
}
