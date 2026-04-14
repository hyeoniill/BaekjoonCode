class Solution {
    public static int answer = 0;
    public int solution(int a, int b, int n) {
        if(n < a) {
            return answer;
        } else {
            answer += b*(n/a);
            return solution(a, b, b * (n/a) + n%a);
        }
    }
}