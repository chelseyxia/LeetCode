class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        StringBuilder result = new StringBuilder();
        Map<String, String> raw = new HashMap<>();
        for(List<String> r : replacements){
            raw.put(r.get(0), r.get(1));
        }
        Map<String, String> memo = new HashMap<>();
        Set<String> path = new HashSet<>();
        for(String k : raw.keySet()){
            expand(k, raw, memo, path);
        }
        for(int i = 0; i < text.length();){
            char c = text.charAt(i);
            if(c == '%'){
                int j = text.indexOf('%', i+1);
                if(j == -1){
                    result.append(c);
                    i++;
                    continue;
                }
                String var = text.substring(i+1, j);
                String val = memo.getOrDefault(var, "");
                result.append(val);
                i = j + 1;
            }
            else{
                result.append(c);
                i++;
            }

        }
        return result.toString();
    }
    public String expand(String key, Map<String, String> raw, Map<String, String> memo, Set<String> path){
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(!raw.containsKey(key)){
            return "";
        }
        if(!path.add(key)){
            return "";
        }
        String val = raw.get(key);
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < val.length();){
            char c = val.charAt(i);
            if(c == '%'){
                int j = val.indexOf('%', i+1);
                if(j == -1){
                    out.append(c);
                    i++;
                    continue;
                }
                String inner = val.substring(i+1, j);
                out.append(expand(inner, raw, memo, path));
                i = j + 1;
            }
            else{
                out.append(c);
                i++;
            }
        }
        path.remove(key);
        String done = out.toString();
        memo.put(key, done);
        return done;
    }
}
