class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for(int j = 1; j <= rowIndex; j++){
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> preList = res.get(j - 1);
            list.add(1);
            for(int i = 1; i < j; i++){
                list.add(preList.get(i - 1) + preList.get(i));
            }
            list.add(1);
            res.add(list);
        }
        return res.get(rowIndex);
    }
}
