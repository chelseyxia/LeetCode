class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        if(left == right){
            return true;
        }
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        if(left >= right){
            return true;
        }
        if(isPlain(s, left + 1, right) || isPlain(s, left, right - 1)){
            return true;
        }
        return false;
    }
    public boolean isPlain(String s, int i, int j){
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        if(i >= j){
            return true;
        }
        else{
            return false;
        }
    }
}
