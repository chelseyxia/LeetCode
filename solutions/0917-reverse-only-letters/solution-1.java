class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i < j){
            if(!(Character.isLetter(ch[i])) && !(Character.isLetter(ch[j]))){
                i++;
                j--;
            }
            else if((Character.isLetter(ch[i])) && (Character.isLetter(ch[j]))){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
            else if(!(Character.isLetter(ch[i])) && (Character.isLetter(ch[j]))){
                i++;
            }
            else{
                j--;
            }
        }
    return new String(ch);
    }
}
