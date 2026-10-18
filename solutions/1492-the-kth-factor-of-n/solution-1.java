class Solution {
    public int kthFactor(int n, int k) {
        //4: 1, 2, 4  4th: -1
        List<Integer> list = new ArrayList();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                list.add(i);
                //n / 1; n / 2; n / 3; n / 4 
                //12 / 1, 2,3,4,6,12
            }
        }
        if(list.size() < k){
            return -1;
        }
        return list.get(k - 1);
    }
}
