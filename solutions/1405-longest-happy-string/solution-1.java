class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        int A = 0;
        int B = 0;
        int C = 0;
        while(a > 0 && A < 2 || b > 0 && B < 2 || c > 0 && C < 2){
            if((a >= b && a >= c && A < 2) || (a > 0 && B == 2) || (a > 0 && C == 2)){
                res.append("a");
                B = 0;
                C = 0;
                A++;
                a--;
            }
            else if((b >= a && b >= c && B < 2) || (A == 2 && b > 0) || (b > 0 && C == 2)){
                res.append("b");
                A = 0;
                C = 0;
                B++;
                b--;
            }
            else if((c >= a && c >= b && C < 2) || (c > 0 && A == 2) || (c > 0 && B == 2)){
                res.append("c");
                c--;
                A = 0;
                B = 0;
                C++;
            }
        }        
        return res.toString();
    }
}
