class Solution {
    public int openLock(String[] deadends, String target) {
        //从 0000 出发，把一步能到的所有状态都加入 queue
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        if(dead.contains("0000")){
            return -1;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                if(cur.equals(target)){
                    return res;
                }
                List<String> neighbors = getNeighbors(cur);
                for(int j = 0; j < neighbors.size(); j++){
                    if(dead.contains(neighbors.get(j)) || visited.contains(neighbors.get(j))){
                        continue;
                    }
                    queue.offer(neighbors.get(j));
                    visited.add(neighbors.get(j));
                }
            }
            res++;
        }
        return -1;
    }
    public List<String> getNeighbors(String cur){
        List<String> neighbors = new ArrayList<>();
        char[] c = cur.toCharArray();
        for(int i = 0; i < cur.length(); i++){
            char originChar = c[i];
            int digit = c[i] - '0';
            c[i] = (char)((digit + 1) % 10 + '0');
            neighbors.add(new String(c));
            c[i] = (char)((digit + 9) % 10 + '0');
            neighbors.add(new String(c));
            c[i] = originChar;
        }
        return neighbors;
    }
}
