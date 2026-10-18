class Solution {
    public boolean wordPattern(String pattern, String s) {
        //boolean pattern == s
        String[] newS = s.split(" ");
        if(newS.length != pattern.length()){
            return false;
        }
        
        Map<Object, Integer> map = new HashMap();
        for(Integer i = 0; i < newS.length; i++){
            if(map.put(pattern.charAt(i), i) != map.put(newS[i], i)){
                return false;
            }
        }
        return true;
    }
}
