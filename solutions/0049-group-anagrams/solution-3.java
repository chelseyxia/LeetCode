class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> list = new ArrayList();
        HashMap<String, List<String>> map = new HashMap();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String ts = new String(arr);
            if(map.containsKey(ts)){
                List<String> t = map.get(ts);
                t.add(str);
                map.put(ts, t);
            }
            else{
                List<String> t = new ArrayList();
                t.add(str);
                map.put(ts, t);
            }
        }
        for(String str : map.keySet()){
            list.add(map.get(str));
        }
        return list;
    }
}
