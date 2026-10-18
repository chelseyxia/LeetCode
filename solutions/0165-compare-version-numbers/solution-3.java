class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int i = 0, j = 0;
        while(i < n1 || j < n2){
            int x = 0, y = 0;
            for(; i < n1 && version1.charAt(i) != '.'; i++){
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++;
            for(; j < n2 && version2.charAt(j) != '.'; j++){
                y = y * 10 + version2.charAt(j) - '0';
            }
            j++;
            if(x != y){
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
