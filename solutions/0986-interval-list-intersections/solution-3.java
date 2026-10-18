class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < firstList.length && j < secondList.length){
            int ff = firstList[i][0], fe = firstList[i][1];
            int sf = secondList[j][0], se =  secondList[j][1];
            int maxS = Math.max(ff, sf);
            int minE = Math.min(fe, se);
            if(maxS <= minE){
                res.add(new int[]{maxS, minE});
            }
            if(fe < se){
                i++;
            }
            else if(fe > se){
                j++;
            }
            else{
                i++;
                j++;
            }
        }
        if(i == firstList.length - 1 && j < secondList.length - 1){
            for(int k = j; k < secondList.length; k++){
                res.add(new int[]{secondList[k][0], secondList[k][1]});
            }
        }
        if(j == secondList.length - 1 && i < firstList.length - 1){
            for(int k = i; k < firstList.length; k++){
                res.add(new int[]{firstList[k][0], firstList[k][1]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
