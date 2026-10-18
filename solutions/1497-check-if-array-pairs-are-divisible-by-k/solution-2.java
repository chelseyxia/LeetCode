class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] cnt = new int[k];
        for(int num : arr){
            cnt[(num % k + k) % k]++;
        }
        if((cnt[0] & 1 ) == 1){
            return false;
        }
        int left = 1;
        int right = k - 1;
        while(left < right){
            if(cnt[left++] != cnt[right--]){
                return false;
            }
        }
        if(left == right && (cnt[0] & 1) == 1){
            return false;
        }
        
        return true;
    }
}
