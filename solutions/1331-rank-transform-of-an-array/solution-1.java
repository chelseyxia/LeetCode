class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();

        int[] temp = arr.clone();
        Arrays.sort(temp);
        int count = 1;
        for(int i = 0; i < temp.length; i++){
            if(map.get(temp[i]) == null){
                map.put(temp[i], count);
                count++;               
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}

//40, 0   10, 1  20, 2  30 3
//10, 20, 30, 40
