class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        Map<String, List<String>> combo_dic = new HashMap();
        wordList.forEach(
            word -> {
                for(int i = 0; i < L; i++){
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                    List<String> transformations = combo_dic.getOrDefault(newWord, new ArrayList<>());
                    transformations.add(word);
                    combo_dic.put(newWord, transformations);
                }
            }
        );
        Queue<Pair<String, Integer>> queue = new LinkedList();
        queue.add(new Pair(beginWord, 1));
        Map<String, Boolean> visited = new HashMap();
        visited.put(beginWord, true);
        while(!queue.isEmpty()){
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int i = 0; i < L; i++){
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                for(String adjacentWord : combo_dic.getOrDefault(newWord, new ArrayList<>())){
                    if(adjacentWord.equals(endWord)){
                        return level + 1;
                    }
                    if(!visited.containsKey(adjacentWord)){
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
