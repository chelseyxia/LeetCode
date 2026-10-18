class Solution {
    public boolean isPalindrome(int x) {
        //edge case: x < 0
        //algorithm: two pointers
        // length -> odd / even
        //examples: 1221 121 
        /*if(x < 0){
            return false;
        }
        String newX = Integer.toString(x);
        int length = newX.length();
        int p2 = length - 1;
        int p1 = 0;
        while(p1 <= p2){
            char ch1 = newX.charAt(p1);
            char ch2 = newX.charAt(p2);
            if(ch1 == ch2){
                p1++;
                p2--;
            }
            else{
                return false;
            }
        }
        return true;*/
        //create a brand new int and see if it's same with x
        int x1 = x;
        int ans = 0;
        while(x > 0){
            ans = ans * 10;
            ans = ans + x % 10;
            x = x / 10;
        }
        return ans == x1;
    }
}
