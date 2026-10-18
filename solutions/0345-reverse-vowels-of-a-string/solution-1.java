class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        if(n <= 1){
            return s;
        }
        int p1 = 0;
        int p2 = n - 1;
        char[] s_array = s.toCharArray();
        
        while( p1 < p2){
            if(char_(s_array[p1]) && char_(s_array[p2])){
                char temp = s_array[p1];
                s_array[p1] = s_array[p2];
                s_array[p2] = temp;
                p1++;
                p2--;
            }
            if(!char_(s_array[p1])){
                p1++;
            }
            if(!char_(s_array[p2])){
                p2--;
            }
        }
        return new String(s_array);
    }
    
    public boolean char_(char n){
        return n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u' || n == 'A' || n == 'E' || n == 'I' || n == 'O' || n == 'U';
    }
}
