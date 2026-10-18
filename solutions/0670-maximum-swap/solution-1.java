class Solution {
    public int maximumSwap(int num) {
        //only can move 1 time
        //if: 7236 -> swap 2 & 6
        //if: 2736 -> swap 2 & 7
        //if: 9973 -> swap nothing
        //how? 
        char[] arr = Integer.toString(num).toCharArray();
        int maxIdx = arr.length - 1;
        int[] maxArr = new int[arr.length];
        //iterate from the last index
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] > arr[maxIdx]){
                maxIdx = i;
            }
            maxArr[i] = maxIdx;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[maxArr[i]] != arr[i]){
                char temp = arr[maxArr[i]];
                arr[maxArr[i]] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        
        return Integer.parseInt(new String(arr));
    }
}
