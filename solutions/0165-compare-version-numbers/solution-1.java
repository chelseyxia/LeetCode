class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length;
        int n2 = nums2.length;
        /*for(int i = 0; i < math.max(n1, n2); i++){
            if(nums1[i] < nums2[i]){
                return -1;
            }
            if()
        }*/
        int i = 0;
        while(i < Math.min(n1, n2)){
            if(Integer.parseInt(nums1[i]) < Integer.parseInt(nums2[i])){
                return -1;
                //break;
            }
            else if(Integer.parseInt(nums1[i]) > Integer.parseInt(nums2[i])){
                return 1;
                //break;
            }
            else if(Integer.parseInt(nums1[i]) == Integer.parseInt(nums2[i])){
                i++;
            }
        }
        
        if(n1 > n2){
            for(int j = i; j < n1; j++){
                if(Integer.parseInt(nums1[j]) > 0){
                    return 1;
                }
            }
        }
        if(n1 < n2){
            for(int j = i; j < n2; j++){
                if(Integer.parseInt(nums2[j]) > 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
