class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ans = s.toCharArray();
        for(int i = 0; i < n; i += 2 * k){
            reverse(ans, i, Math.min(i + k, n) - 1);
        }
        return new String(ans);
    }
      
    public void reverse(char[] s, int left, int right){
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
