class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        
        for(int i = 0; i < n;){
            int j = i;
            
            while(j < n && chars[i] == chars[j]){
                j++;
            }
            
            chars[write++] = chars[i];
            if(j - i > 1){
                String temp = Integer.toString(j - i);
                for(int k = 0; k < temp.length(); k++){
                    chars[write++] = temp.charAt(k);
                }
            }
            i = j;
        }       
        return write;
    }
}
