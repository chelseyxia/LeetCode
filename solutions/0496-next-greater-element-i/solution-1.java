class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        //find nums1[i] in nums2[]'s index, then compare the next value
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n2; i++){
            map.put(nums2[i], i);
        }
        int key = 0;
        for(int i = 0; i < n1; i++){
            if(map.containsKey(nums1[i])){
                key = map.get(nums1[i]);
            }   
            if(key == n2 - 1){
                ans[i] = -1;
            }
            if(key < n2 - 1){
                int j = key + 1;
                while(j < n2){
                    if(nums2[j] > nums1[i]){
                        ans[i] = nums2[j];
                        break;
                    }
                    else{
                        j++;
                    }
                    ans[i] = -1;
                }
                //else{
                  //  ans[i] = -1;
                //}
            }
                //if(nums2[key + 1] > nums1[i]){
                  //  ans[i] = nums2[key + 1];
                //}

            
        }     
        return ans;
    }
}
