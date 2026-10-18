class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        int end = arr[arr.length - 1];
        int layers = 0;
        boolean[] visited = new boolean[arr.length];
        queue.offer(0);
        visited[0] = true;
        if(arr.length <= 1){
            return 0;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int index = queue.poll();
                if(index == arr.length - 1){
                    return layers;
                }
                int val = arr[index];
                List<Integer> list = map.get(val);
                map.remove(val);
                if(list != null){
                    for(int j = 0; j < list.size(); j++){
                        if(!visited[list.get(j)] && list.get(j) != index){
                            queue.offer(list.get(j));
                            visited[list.get(j)] = true;
                        }
                    }
                }
                if(index + 1 < arr.length && !visited[index + 1]){
                    queue.offer(index + 1);
                    visited[index + 1] = true;
                }
                if(index - 1 >= 0 && !visited[index - 1]){
                    queue.offer(index - 1);
                    visited[index - 1] = true;
                }
            }
            layers++;
        }
        return -1;
    }
}
