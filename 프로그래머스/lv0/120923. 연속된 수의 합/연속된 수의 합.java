class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int basis = total/num - num/2;
        if(num % 2 == 0) {
            basis++;
        }
        for(int i=0; i<answer.length; i++) {
            answer[i] = basis;
            basis++;
        }
        return answer;
    }
}