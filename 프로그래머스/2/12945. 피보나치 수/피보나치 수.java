class Solution {
    public int solution(int n) {
        
        int a = 0;
        int b = 1;
        boolean order = true;
        
        for(int i=0; i<n; i++) {
            if(order) {
                a = (a + b) % 1234567;
            } else {
                b = (a + b) % 1234567;
            }         
            order = !order;
        }       
        
        return order ? a : b;
    }       
}
