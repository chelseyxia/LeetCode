class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // two possibilities
        int n = nums1.length + nums2.length;
        int[] num = new int[n];
        int j = 0;
        double median = 0;
        for(int i = 0; i < nums1.length; i++){
            num[i] = nums1[i];
        }
        for(int i = nums1.length; i < n; i++){
            num[i] = nums2[j];
            j++;
        }
        Arrays.sort(num);
        if(num.length % 2 != 0){
            median = num[num.length / 2];
        }
        else{
            median = (num[num.length / 2] + num[num.length / 2 - 1]) / 2.0;
        }
        return median;
    }
}
