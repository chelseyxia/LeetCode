class Solution {
    public long numberOfWays(String s) {
        if(s.length() < 3){
            return 0;
        }
        long res = 0;
        //book = "01001" -> 010 / 010 / 101/ 101
        long lZero = 0, lOne = 0;
        long rZero = 0, rOne = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                rZero++;
            }
            else{
                rOne++;
            }
        }
        if(s.charAt(0) == '0'){
            lZero++;
            rZero--;
        }
        else{
            lOne++;
            rOne--;
        }
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                rZero--;
                res += lOne * rOne;
                lZero++;
            }
            else{
                rOne--;
                res += lZero * rZero;
                lOne++;
            }
        }
        return res;
    }
}
