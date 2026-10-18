class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sbS = new StringBuilder();
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '#'){
                stackS.add(ch);
            }
            if(ch == '#'){
                if(!stackS.isEmpty()){
                    stackS.pop();
                }
                else if(stackS.isEmpty()){
                    continue;
                }
            }
        }
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(ch != '#'){
                stackT.add(ch);
            }
            if(ch == '#'){
                if(!stackT.isEmpty()){
                    stackT.pop();
                }
                else if(stackT.isEmpty()){
                    continue;
                }
            }
        }
        if(stackS.size() != stackT.size()){
            return false;
        }
        while(!stackS.isEmpty()){
            char chS = stackS.pop();
            char chT = stackT.pop();
            if(chS != chT){
                return false;
            }
        }
        return stackS.isEmpty() && stackT.isEmpty();
    }
}
