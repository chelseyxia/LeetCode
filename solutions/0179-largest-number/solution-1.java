class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        for(int num : nums){
            heap.offer(String.valueOf(num));
        }
        String res = "";
        while(heap.size() > 0){
            res += heap.poll();
        }
        if(res.charAt(0) == '0'){
            return "0";
        }
        return res;
    }
}
