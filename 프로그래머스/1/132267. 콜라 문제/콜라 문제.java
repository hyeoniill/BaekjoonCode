class Solution {
    public int solution(int a, int b, int n) {
        int exchanged = (n/a)*b;
        int remain = (n%a) + exchanged;
        if(n < a) {
            return 0;
        } 
            return exchanged + solution(a, b, remain);
        
    }
}


