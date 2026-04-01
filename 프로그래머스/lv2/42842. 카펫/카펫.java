class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int row = 0;
        int col = 0;
        
        for(int i=(brown/2)-1; i>brown/4; i--) {
            for(int j=1; j<=i; j++) {
                if(i*j == total && (i-2)*(j-2)==yellow) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        
        
        answer[0] = row;
        answer[1] = col;
        
        return answer;
    }
}