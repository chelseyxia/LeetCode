class Solution {
    public void reverseString(char[] s) {
        int n = s.length - 1;
        int i = 0;
       /* for(int i = 0, n = s.length - 1; i < s.length, n >= 0; i++, n--){
            s[i] = s[n];
        }*/
        while(i < n){
            char temp = s[0];
            temp = s[i];
            s[i] = s[n];
            s[n] = temp;
            i++;
            n--;
        }
       // return s;
    }
}
