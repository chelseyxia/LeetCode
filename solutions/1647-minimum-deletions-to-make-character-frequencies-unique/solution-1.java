class Solution {
    public int minDeletions(String s) {
        int[] a = new int[26];
        char[] s_array = s.toCharArray();
        for(char ch : s_array){
            a[ch - 'a'] ++;
        }
        
        Set<Integer> set = new HashSet();
        
        int res = 0;
        for(int i : a){
            while(set.contains(i)){
                i--;
                res++;
            }
            if(i != 0){
                set.add(i);
            }
        }
        
        
        return res;
    }
}
