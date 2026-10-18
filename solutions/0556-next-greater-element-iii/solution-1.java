class Solution {
    public int nextGreaterElement(int n) {
        //special value
        if(n < 10){
            return -1;
        }
        int[] arr = toList(n);
        int len = arr.length;
        
        int right = len - 1;
        int left = right;
        
        while(right > 0 && arr[right - 1] >= arr[right]){
            right--;
            if(right == 0){
                return -1;
            }            
        }
        
        left = right - 1;
        right = len - 1;
        while(right > left && arr[left] >= arr[right]){
            right--;
        }
        
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        
        left = left + 1;
        right = len - 1;
        
        while(left < right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        
        return toInteger(arr);
    }
    
    private int[] toList(int n){
        int len = 1;
        int v = n;
        
        while(v / 10 > 0){
            len++;
            v = v / 10;
        }
        
        int mod = 1;
        int[] arr = new int[len];
        for(int i = len - 1; i >= 0; i--){
            arr[i] = n % 10;
            n = n / 10;
        }
        return arr;
    }
    
    private int toInteger(int[] arr){
        long val = 0;
        long maxInt = Long.valueOf(String.valueOf(Integer.MAX_VALUE));
        long mult = 1;
        
        for(int i = arr.length - 1; i >= 0; i--){
            long l = arr[i] * mult;
            if(val > maxInt || l > maxInt){
                return -1;
            }
            val += arr[i] * mult;
            mult *= 10;
        }
        
        return val > maxInt ? -1 : Integer.parseInt(String.valueOf(val));
    }
}
