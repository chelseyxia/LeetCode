class Solution {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS != lenT){
            return false;
        }
        int[] s_arr = new int[26];
        for(int i = 0; i < lenS; i++){
            char ch = s.charAt(i);
            int index = ch - 'a';
            s_arr[index]++;
        }
        for(int j = 0; j < lenS; j++){
            char ch = t.charAt(j);
            int index = ch - 'a';
            s_arr[index]--;
        }
        for(int i = 0; i < 26; i++){
            if(s_arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
