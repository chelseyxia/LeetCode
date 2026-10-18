class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i > 0; i--){
            if(arr[i] != " "){
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        if(arr[0] == " "){
            return sb.toString();
        }
        sb.append(arr[0]);
        return sb.toString();
    }
}
