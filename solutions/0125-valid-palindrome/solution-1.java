class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer c = new StringBuffer();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                c.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer c_rev = new StringBuffer(c).reverse();
        return c.toString().equals(c_rev.toString());
    }
}
