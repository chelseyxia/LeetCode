class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        //we must use carry in this problem, otherwise it will oeverflow
        int n1 = num1.length();
        int n2 = num2.length();
        
        int[] res = new int[n1 + n2];
        for(int i = n1 - 1; i >= 0; i--){
            int m1 = num1.charAt(i) - '0';
            for(int j = n2 - 1; j >= 0; j--){
                int m2 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + m1 * m2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        
        for(int k = 0; k < res.length; k++){
            if(k == 0 && res[k] == 0){
                continue;
            }
            result.append(res[k]);
        }
        
        return result.toString();
    }
}
