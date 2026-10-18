class Solution {
    public boolean equationsPossible(String[] equations) {
        Queue<Character> queue = new LinkedList<>();
        Map<Character, List<Character>> map = new HashMap<>();
        for(String e : equations){
            char a = e.charAt(0);
            char b = e.charAt(3);
            if(e.charAt(1) == '='){
                map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            }
        }
        boolean[] visited = new boolean[26];
        int[] componentId = new int[26];
        Arrays.fill(componentId, -1);
        int id = 0;
        for(char key : map.keySet()){
            if(!visited[key - 'a']){
                queue.offer(key);
                visited[key - 'a'] = true;
                while(!queue.isEmpty()){
                    char cur = queue.poll();
                    componentId[cur - 'a'] = id;
                    List<Character> candidates = map.get(cur);
                    for(char c : candidates){
                        if(!visited[c - 'a']){
                            visited[c - 'a'] = true;
                            queue.offer(c);
                        }
                    }
                }
                id++;
            }
        }
        for(String e : equations){
            if(e.charAt(1) == '!'){
                char a = e.charAt(0);
                char b = e.charAt(3);
                if(componentId[a - 'a'] != -1 && componentId[b - 'a'] != -1 && a != b && componentId[a - 'a'] == componentId[b - 'a']){
                    return false;
                }
                if(a == b){
                    return false;
                }
            }
        }
        return true;
    }
}
