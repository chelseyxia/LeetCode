class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                if(cur.equals(endGene)){
                    return steps;
                }
                for(int j = 0; j < bank.length; j++){
                    String s = bank[j];
                    if(isNeighbor(cur, s) && !visited.contains(s)){
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public boolean isNeighbor(String cur, String b){
        int diff = 0;
        for(int i = 0; i < b.length(); i++){
            char curChar = cur.charAt(i);
            char bankChar = b.charAt(i);
            if(curChar != bankChar){
                diff++;
            }
        }
        return diff == 1;
    }
}
