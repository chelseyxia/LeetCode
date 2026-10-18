class Solution {
    public String originalDigits(String s) {
        char[] count = new char[26 + (int)'a'];
        for(char ch : s.toCharArray()){
            count[ch]++;
        }
        int[] digit = new int[10];
        digit[2] = count['w'];
        digit[0] = count['z'];
        digit[6] = count['x'];
        digit[4] = count['u'];
        digit[8] = count['g'];
        digit[3] = count['h'] - digit[8];
        digit[5] = count['f'] - digit[4];
        digit[7] = count['s'] - digit[6];
        digit[9] = count['i'] - digit[5] - digit[6] - digit[8];
        digit[1] = count['n'] - digit[7] - 2 * digit[9];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < digit[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
