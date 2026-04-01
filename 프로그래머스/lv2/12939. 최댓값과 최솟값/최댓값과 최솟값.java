class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] iarr = new int[arr.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<iarr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return min+ " "+ max;
    }
}



