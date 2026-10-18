class Solution {
    public boolean validPalindrome(String s) {
        int low = 0; int high = s.length() - 1;
        while(low < high){
            char a = s.charAt(low);
            char b = s.charAt(high);
            if(a == b){
                ++low;
                --high;
            }
            else{
                return validPalindrome(s, low, high-1) || validPalindrome(s, low+1, high);
            }
        }
        return true;
    }
    public boolean validPalindrome(String s, int low, int high){
        for(int i = low, j = high; i < j; ++i, --j){
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if(c1 != c2){
                return false;
            }
        }
        return true;
    }
}
