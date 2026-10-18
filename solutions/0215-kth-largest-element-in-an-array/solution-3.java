class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
//1,2,3,4,5,6 -> 5
//1, 2, 2, 3, 4, 5, 5, 6 -> 4
