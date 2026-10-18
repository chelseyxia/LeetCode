class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Queue<Pair<Integer, String[]>> pairs = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for(int i = 0; i < n; i++){
            pairs.offer(new Pair<>(timestamp[i], new String[]{username[i], website[i]}));
        }
        
        Map<String, List<String>> history = new HashMap();
        while(!pairs.isEmpty()){
            String[] p = pairs.poll().getValue();
            history.putIfAbsent(p[0], new ArrayList<>());
            history.get(p[0]).add(p[1]);
        }
        
        Map<String, Integer> frequency = new HashMap<>();
        int max = 0;
        
        for(List<String> h : history.values()){
            Set<String> set = new HashSet();
            
            for(int i = 0; i < h.size(); i++){
                for(int j = 0; j < i; j++){
                    for(int k = 0; k < j; k++){
                        set.add(h.get(k) + "#" + h.get(j) + "#" + h.get(i));
                    }
                }
            }
            
            for(String key : set){
                frequency.put(key, frequency.getOrDefault(key, 0) + 1);
                max = Math.max(max, frequency.get(key));
            }
        }
        
        TreeSet<String> set = new TreeSet();
        
        for(Map.Entry<String, Integer> entry : frequency.entrySet()){
            if(entry.getValue() == max){
                set.add(entry.getKey());
            }
        }
        
        return Arrays.asList(set.first().split("#")); 
        
    }
}
