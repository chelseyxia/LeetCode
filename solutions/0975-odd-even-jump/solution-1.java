class Solution {
    public int oddEvenJumps(int[] arr) {
        //dynamic programming
        //because we have odd and even jump, we assign 2 boolean arrays for odd and even jump
        int n = arr.length;
        int res = 1;
        boolean[] oddJump = new boolean[n];
        boolean[] evenJump = new boolean[n];
        //the last element is always true;
        oddJump[n - 1] = evenJump[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for(int i = n - 2; i >= 0; i--){
            Map.Entry hi = map.ceilingEntry(arr[i]);
            Map.Entry lo = map.floorEntry(arr[i]);
            if(hi != null){
                oddJump[i] = evenJump[(int)hi.getValue()];
            }
            if(lo != null){
                evenJump[i] = oddJump[(int)lo.getValue()];
            }
            if(oddJump[i]){
                res++;
            }
            map.put(arr[i], i);
        }
        return res;
    }
}
