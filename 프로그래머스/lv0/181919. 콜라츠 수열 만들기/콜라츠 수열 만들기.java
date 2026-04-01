class Solution {
    public int[] solution(int n) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(n + " ");
        while(n != 1) {
            if(n%2==0) {
                n/=2;
                sb.append(n + " ");
            } else {
                n = n * 3 + 1;
                sb.append(n + " ");
            }
        }
        
        String[] arr = sb.toString().split(" ");
        int[] answer = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }
        return answer;
    }
}