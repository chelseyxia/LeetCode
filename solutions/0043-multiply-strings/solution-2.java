class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int carry = 0;
        int[] res = new int[n1 + n2];
        for(int i = n1 - 1; i >= 0; i--){
            int ch1 = num1.charAt(i) - '0';
            for(int j = n2 - 1; j >= 0; j--){
                int ch2 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + ch1 * ch2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            if(i == 0 && res[i] == 0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
