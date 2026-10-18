public class ZigzagIterator {
    private List<List<Integer>> vectors = new ArrayList<>();
    private int pVec = 0, pElem = 0;
    private int totalCnt = 0, outCnt = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vectors.add(v1);
        this.vectors.add(v2);
        for(List<Integer> vec : vectors){
            this.totalCnt += vec.size();
        }
    }

    public int next() {
        Integer iterNum = 0, ret = null;
        while(iterNum < vectors.size()){
            List<Integer> currVec = vectors.get(this.pVec);
            if(this.pElem < currVec.size()){
                ret = currVec.get(pElem);
                outCnt += 1;
            }
            iterNum += 1;
            this.pVec = (pVec + 1) % vectors.size();
            if(pVec == 0){
                pElem += 1;
            }
            if(ret != null){
                return ret;
            }
        }
        return 0;
    }

    public boolean hasNext() {
        return outCnt < this.totalCnt;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
