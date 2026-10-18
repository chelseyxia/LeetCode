class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                long sum = arr[left] + arr[right] + arr[i];
                if(sum < target){
                    left++;
                }
                else if(sum > target){
                    right--;
                }
                else{
                    if(arr[left] == arr[right]){
                        long cntleft = 1;
                        while(left != right){
                            left++;
                            cntleft++;
                        }
                        ans += cntleft * (cntleft - 1) / 2;
                        ans = ans % 1000000007;
                    }  
                    else{
                        long cntleft = 1;
                        long cntright = 1;
                        while(left + 1 < right && arr[left + 1] == arr[left]){
                            left++;
                            cntleft++;
                        }
                        while(right - 1 > left && arr[right - 1] == arr[right]){
                            right--;
                            cntright++;
                        }
                        ans += cntleft * cntright;
                        ans = ans % 1000000007;
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
