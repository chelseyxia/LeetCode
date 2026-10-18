class Solution {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        if(n1 < n2){
            return -1;
        }
        if(haystack == " " && needle == " "){
            return 0;
        }
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        
        return -1;
    }
}
