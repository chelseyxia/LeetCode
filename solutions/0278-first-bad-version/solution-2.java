/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int firstB = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            boolean isB = isBadVersion(mid);
            if(!isB){
                left = mid + 1;
            }
            else{
                firstB = mid;
                right = mid - 1;
            }
        }
        return firstB;
    }
}
