class Solution {
    public int uniqueLetterString(String s) {
        int len = s.length();
        int[] exist = new int[26];
        Arrays.fill(exist, -1);
        int[] left = new int[len];
        Arrays.fill(left, -1);
        int[] right = new int[len];
        Arrays.fill(right, -1);
        
        for(int i = 0; i < len; i++){
            if(exist[s.charAt(i) - 'A'] != -1){
                left[i] = exist[s.charAt(i) - 'A'];
            }
            exist[s.charAt(i) - 'A'] = i;
        }
        
        Arrays.fill(exist, -1);
        for(int i = len - 1; i >= 0; i--){
            if(exist[s.charAt(i) - 'A'] != -1){
                right[i] = exist[s.charAt(i) - 'A'];
            }
            exist[s.charAt(i) - 'A'] = i;
        }
        
        int res = 0;
        for(int i = 0; i < len; i++){
            int leftBound = left[i] == -1 ? 0 : left[i] + 1;
            int rightBound = right[i] == -1 ? len - 1 : right[i] - 1;
            res += (i - leftBound + 1) * (rightBound - i + 1);
        }
        
        return res;
    }
}
