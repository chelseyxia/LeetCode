class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        // 特判
        if(n == 0) return 0;
        // 定义哈希表，第一个键表示数组下标索引，其嵌套的哈希表用于存储该元素以不同的公差所包含的最长序列
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 1;
        // 遍历数组
        for(int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            // 向前遍历，寻找不同公差的最长序列
            for(int j = i - 1; j >= 0; j--) {
                // 如果遇到了重复的元素，可以直接跳过，因为肯定不会比后面的元素能组成更长的序列
                if(map.get(i).containsKey(nums[i] - nums[j])) continue;
                // 获取以这两个元素差为公差的最长子序列
                int cur =  map.get(j).getOrDefault(nums[i] - nums[j], 0);
                // 比较答案
                res = Math.max(res, cur + 2);
                // 存入当前元素，某公差下的最长序列
                map.get(i).put(nums[i] - nums[j], cur + 1);
            }
        }
        return res;
    }
}
