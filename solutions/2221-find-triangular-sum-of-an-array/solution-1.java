class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(nums[i]);
        }
        while(list.size() != 1){
            for(int i = 1; i < list.size(); i++){
                int temp = (list.get(i - 1) + list.get(i)) % 10;
                list.set(i - 1, temp);
            }
            list.remove(list.size() - 1);
        }
        return list.get(0) % 10;
    }
}
