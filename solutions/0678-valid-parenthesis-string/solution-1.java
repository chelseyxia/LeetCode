class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> star = new Stack();
        Stack<Integer> left = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                left.push(i);
            }
            if(c == '*'){
                star.push(i);
            }
            if(c == ')'){
                if(!left.empty()){
                    left.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }
                else{
                    return false;
                }
            } 
        }
        
        while(!left.isEmpty()){
            int posL = left.peek();
            if(star.isEmpty()){
                return false;
            }
            int posS = star.peek();
            if(posS > posL){
                star.pop();
                left.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}
