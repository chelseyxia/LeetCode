class Solution {
    final static int a = 97;
    final static int size = 26;
    public int minSteps(String s, String t) {
        int ns = s.length();
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] arr = new int[size];
        for(int i = 0; i < ns; i++){
            int sci = s_arr[i] - a;
            int tci = t_arr[i] - a;
            arr[sci] += 1;
            arr[tci] -= 1;
            
        }
        int ans = 0;
        for(int n : arr){
            if(n > 0){
                ans += n;
            }
        }
        return ans;
    }
}
