class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                int k = map.get(nums1[i]);
                if(k + 1 >= nums2.length){
                    ans[i] = -1;
                }
                else if((k + 1) < nums2.length){
                    for(int j = k + 1; j < nums2.length; j++){
                        if((nums2[j] > nums1[i])){
                            ans[i] = nums2[j];
                            break;
                        }   
                        if(nums2[j] < nums1[i]){
                            ans[i] = -1;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
