class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int nk = keysPressed.length();
        int n = 0;
        int temp = 0;
        int max = releaseTimes[0];
        char result = keysPressed.charAt(0);
        for(int i = 0; i < nk - 1; i++){
            temp = releaseTimes[i + 1] - releaseTimes[i];
            if(temp > max){
                max = temp;
                result = keysPressed.charAt(i+1);
            }
            if(temp == max && keysPressed.charAt(i+1) > result){
                result = keysPressed.charAt(i+1);
            }
        }
        return result;
    }
}
