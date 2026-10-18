class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length - 1; i++){
            String temp = arr[i];
            for(int j = temp.length() - 1; j >= 0; j--){
                char ch = temp.charAt(j);
                sb.append(ch);
            }
            sb.append(" ");
        }
        String t = arr[arr.length - 1];
        for(int k = t.length() - 1; k >= 0; k--){
            char ch = t.charAt(k);
            sb.append(ch);
        }
        return sb.toString();
    }
}
