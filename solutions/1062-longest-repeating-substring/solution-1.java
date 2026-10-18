class Solution {
    public int longestRepeatingSubstring(String s) {
        HashMap<String, Integer> map = new HashMap();
        int n = s.length();
        //binary search
        int left = 1; 
        int right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(search(mid, n, s) != -1){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left - 1;
    }
    
    private int search(int L, int n, String s){
        HashSet<String> seen = new HashSet();
        String temp;
        for(int start = 0; start < n - L + 1; start++){
            temp = s.substring(start, start + L);
            if(seen.contains(temp)){
                return start;
            }
            seen.add(temp);
        }
        return -1;
    }
}
