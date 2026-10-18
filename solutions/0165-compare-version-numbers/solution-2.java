class Solution {
    public int compareVersion(String version1, String version2) {
        String[] num1 = version1.split("\\.");
        String[] num2 = version2.split("\\.");
        int n1 = num1.length;
        int n2 = num2.length;
        for(int i = 0; i < n1 || i < n2; ++i){
            int x = 0, y = 0;
            if(i < n1){
                x = Integer.parseInt(num1[i]);
            }
            if(i < n2){
                y = Integer.parseInt(num2[i]);
            }
            if(x < y){
                return -1;
            }
            if(x > y){
                return 1;
            }
        }
        return 0;
    }
}
