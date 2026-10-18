class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int res = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                if(cur.equals(endWord)){
                    return res;
                }
                for(int j = 0; j < wordList.size(); j++){
                    String word = wordList.get(j);
                    if(isNeighbor(cur, word) && !visited.contains(word)){
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
            res++;
        }

        return 0;
    }
    public boolean isNeighbor(String cur, String word){
        int diff = 0;
        for(int i = 0; i < word.length(); i++){
            char c = cur.charAt(i);
            char w = word.charAt(i);
            if(c != w){
                diff++;
            }
        }
        return diff == 1;
    }
}
