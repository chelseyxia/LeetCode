class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prev = 0;
        int curr = 1;
        char[] arr = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            if(arr[i] != arr[i - 1]){
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
            else{
                curr++;
            }
        }
        ans += Math.min(prev, curr);
        return ans;
    }
}
