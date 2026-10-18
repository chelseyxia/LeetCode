class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            if(a.getValue().equals(b.getValue())){
                return b.getKey().compareTo(a.getKey());
            }
            else{
                return Integer.compare(a.getValue(), b.getValue());
            }
        });
        List<String> ans = new ArrayList<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }
            else{
                Map.Entry<String, Integer> curEntry = minHeap.peek();
                String peekStr = curEntry.getKey();
                int peekFre = curEntry.getValue();
                int newFre = entry.getValue();
                String newStr = entry.getKey();
                if(peekFre < newFre){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
                else if(peekFre == newFre){
                    if(peekStr.compareTo(newStr) > 0){
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
                else{
                    continue;
                }
            }
        }
        while(!minHeap.isEmpty()){
            Map.Entry<String, Integer> entry = minHeap.poll();
            ans.add(0, entry.getKey());
        }
        return ans;
    }
}
