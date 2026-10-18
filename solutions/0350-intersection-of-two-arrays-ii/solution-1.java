class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums1){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for(int n : nums2){
            int cnt = map.getOrDefault(n, 0);
            if(cnt > 0){
                nums1[k++] = n;
                map.put(n, cnt - 1);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
