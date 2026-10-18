class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        
        for(String word : words){
            int sIndex = 0;
            int wIndex = 0;
            
            while(wIndex < word.length() && sIndex < s.length()){
                if(s.charAt(sIndex) != word.charAt(wIndex)){
                    break;
                }
                int c1 = 0;
                int c2 = 0;
                char sChar = s.charAt(sIndex);
                char wChar = word.charAt(wIndex);
                
                while(sIndex <= s.length() - 1 && s.charAt(sIndex) == sChar){
                    c1++;
                    sIndex++;
                }
                while(wIndex <= word.length() - 1 && word.charAt(wIndex) == wChar){
                    c2++;
                    wIndex++;
                }
                
                if(c1 < c2){
                    break;
                }
                
                if(c1 < 3 && c1 != c2){
                    break;
                }
                
                if(wIndex == word.length() && sIndex == s.length()){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
