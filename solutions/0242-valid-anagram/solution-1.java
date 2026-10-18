class Solution {
    public boolean isAnagram(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        if(ns != nt){
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0; i < nt; i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        
        for(int count : counter){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
