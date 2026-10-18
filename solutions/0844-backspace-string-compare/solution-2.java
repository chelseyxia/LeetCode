class Solution {
    public boolean backspaceCompare(String s, String t) {
        return rebuild(s).equals(rebuild(t));
    }
    public String rebuild(String s){
        Stack<Character> stackS = new Stack();
        
        for(char c : s.toCharArray()){
            if(c != '#'){
                stackS.add(c);
            }
            else if(!stackS.empty()){
                stackS.pop();
            }
        }
        
        return String.valueOf(stackS);
    }
}
