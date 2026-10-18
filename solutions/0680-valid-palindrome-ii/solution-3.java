class Solution {
    public boolean validPalindrome(String s) {
        int low = 0; int high = s.length() - 1;
        for(int i = 0; i < s.length() - 1; i++){
            char ch1 = s.charAt(low);
            char ch2 = s.charAt(high);
            if(ch1 == ch2){
                low++;
                high--;
            }
            else{
                return vp(s, low, high - 1) || vp(s, low + 1, high);
            }
        }
        return true;
    }
    public boolean vp(String s, int low, int high){
        for(int i = low, j = high; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
