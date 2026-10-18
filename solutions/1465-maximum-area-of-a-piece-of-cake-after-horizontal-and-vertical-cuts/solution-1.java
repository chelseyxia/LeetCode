class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long area = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n1 = horizontalCuts.length;
        int n2 = verticalCuts.length;
        long w1 = Math.max(verticalCuts[0], w - verticalCuts[n2 - 1]);
        for(int i = 1; i < n2; i++){
            w1 = Math.max(w1, verticalCuts[i] - verticalCuts[i - 1]);
        }
        long h1 = Math.max(horizontalCuts[0], h - horizontalCuts[n1 - 1]);
        for(int i = 1; i < n1; i++){
            h1 = Math.max(h1, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        area = w1 * h1;
        return (int) (area % 1000000007);
    }
}
