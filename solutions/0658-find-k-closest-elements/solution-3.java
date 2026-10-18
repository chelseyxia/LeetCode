class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> stack = new PriorityQueue<>();
        if(arr[0] > x){
            for(int i = 0; i < k; i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        if(arr[arr.length - 1] < x){
            for(int i = arr.length - k; i < arr.length; i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= x){
                left = mid;
            }
            else if(arr[mid] > x){
                right = mid;
            }
            if(right - mid == 1){
                break;
            }
        }
        int l = left, r = right;
        while(k != 0){
            if(l < 0){
                while(k != 0){
                    stack.offer(arr[r]);
                    r++;
                    k--;
                }
                break;
            }
            int leftClose = Math.abs(arr[l] - x);
            if(r >= arr.length){
                while(k != 0){
                    stack.offer(arr[l]);
                    l--;
                    k--;
                }
                break;
            }
            int rightClose = Math.abs(arr[r] - x);
            if(leftClose <= rightClose){
                stack.offer(arr[l]);
                l--;
            }
            else if(leftClose > rightClose){
                stack.offer(arr[r]);
                r++;
            }
            k--;
        }
        while(!stack.isEmpty()){
            ans.add(stack.poll());
        }
        return ans;
    }
}
