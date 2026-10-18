class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] components = path.split("/");
        
        for(String dic : components){
            if(dic.equals(".") || dic.isEmpty()){
                continue;
            }
            else if(dic.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.add(dic);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String dir : stack){
            sb.append("/");
            sb.append(dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
