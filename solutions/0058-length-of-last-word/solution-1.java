class Solution {
    public int lengthOfLastWord(String s) {
        String[] new_s = s.split(" ");
        String ans_s = new_s[new_s.length - 1];
        return ans_s.length();
    }
}
