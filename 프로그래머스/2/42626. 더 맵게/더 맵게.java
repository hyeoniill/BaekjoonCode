import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        int low = 0;
        int high = 0;
        int mix = 0;
        
        for(int sc : scoville) {
            queue.offer(sc);
        }

        while(queue.size() >= 2 && queue.peek() < K) {
            low = queue.poll();
            high = queue.poll();
            
            mix = low + high*2;
            queue.offer(mix);
            count++;
        }
        
        if(queue.peek() < K) {
            return -1;
        }
        return count;
    }
}