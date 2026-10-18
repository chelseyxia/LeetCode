class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        List<Integer> ans = new ArrayList<>();
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
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        int i = left;
        while(k != 0){
            ans.add(arr[i]);
            i++;
            k--;
        }
        return ans;
    }
}
