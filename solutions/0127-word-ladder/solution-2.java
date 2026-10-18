class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //make a pattern use hashmap<String, List<String>>
        int L = beginWord.length();
        Map<String, List<String>> map = new HashMap<>();
        wordList.forEach(
            word ->{
                for(int i = 0; i < L; i++){
                    String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                    map.putIfAbsent(newWord, new ArrayList<>());
                    map.get(newWord).add(word);
                }
            }
        );
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while(!queue.isEmpty()){
            Pair<String, Integer> pair = queue.poll();
            String pairKey = pair.getKey();
            int level = pair.getValue();
            for(int i = 0; i < L; i++){
                String newWord = pairKey.substring(0, i) + "*" + pairKey.substring(i + 1, L);
                for(String adjacentWord : map.getOrDefault(newWord, new ArrayList<>())){
                    if(adjacentWord.equals(endWord)){
                        return level + 1;
                    }  
                    if(!visited.containsKey(adjacentWord)){
                        visited.put(adjacentWord, true);
                        queue.offer(new Pair<>(adjacentWord, level + 1));
                    }
                }

            }
        }
        return 0;
    }
}
