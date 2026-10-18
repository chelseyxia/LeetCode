class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int lastUpper = 0;
        double sum = 0;
        for(int i = 0; i < brackets.length; i++){
            int upper = brackets[i][0];
            int percentage = brackets[i][1];
            int level = upper - lastUpper;
            if(income > upper){
                sum += (double)level * percentage / 100;
                lastUpper = upper;
            }
            else{
                sum += (double)(income - lastUpper) * percentage / 100;
                break;
            }
        }
        return sum;
    }
}
