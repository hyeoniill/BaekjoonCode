import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];

        int answerStart = 0;
        int answerEnd = sequence.length - 1;

        while (start <= end && end < sequence.length) {
            if (sum == k) {
                if (end - start < answerEnd - answerStart) {
                    answerStart = start;
                    answerEnd = end;
                }

                sum -= sequence[start];
                start++;
            } 
            else if (sum > k) {
                sum -= sequence[start];
                start++;
            } 
            else {
                end++;
                if (end < sequence.length) {
                    sum += sequence[end];
                }
            }
        }

        return new int[] {answerStart, answerEnd};
    }
}