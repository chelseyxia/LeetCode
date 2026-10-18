class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        List<Integer> list = new ArrayList();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i]) && !list.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        int n = list.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = list.get(i);
        }
        return ans;
    
    }
}
