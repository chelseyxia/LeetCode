class Solution {
    List<String> ans = new ArrayList();
    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0;
        int rRemove = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                lRemove++;
            }
            
            else if(ch == ')'){
                if(lRemove > 0){
                    lRemove--;
                }
                else{
                    rRemove++;
                }
            }
        }
        
        helper(s, 0, 0, 0, lRemove, rRemove);
        return ans;
    }
    
    public void helper(String s, int index, int lCount, int rCount, int lRemove, int rRemove){
        //base case
        if(lRemove == 0 && rRemove == 0){
            if(isValid(s)){
                ans.add(s);
            }
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            char ch = s.charAt(i);
            if(i == index || ch != s.charAt(i - 1)){
                //base case
                if(lRemove + rRemove > s.length()){
                    return;
                }
                
                if(lRemove > 0 && ch == '('){
                    helper(s.substring(0, i) + s.substring(i + 1), i, lCount, rCount, lRemove - 1, rRemove);
                }
                
                if(rRemove > 0 && ch == ')'){
                    helper(s.substring(0, i) + s.substring(i + 1), i, lCount, rCount, lRemove, rRemove - 1);
                }
            }
            
            if(ch == '('){
                lCount++;
            }
            
            else if(ch == ')'){
                rCount++;
            }
            
            if(rCount > lCount){
                break;
            }
            
        }
    }
    
    public boolean isValid(String curr){
        int count = 0;
        
        for(int i = 0; i < curr.length(); i++){
            char ch = curr.charAt(i);
            if(ch == '('){
                count++;
            }
            
            else if(ch == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}

//()()()  (())()
//(a)()()
