class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int mark = arr.length;
        for(int i = arr.length - 1; i > 0; i--){
            if(arr[i] < arr[i - 1]){
                mark = i - 1;
                arr[i - 1]--;
            }
        }
        for(int j = mark + 1; j < arr.length; j++){
            arr[j] = '9';
        }
        return Integer.parseInt(new String(arr));
    }
}
