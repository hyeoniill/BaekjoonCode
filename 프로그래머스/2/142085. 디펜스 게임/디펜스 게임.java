import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n, int k, int[] enemy) {
        
        /*
        max값 k개를 저장할 자료구조
        앞에서부터 더해가면서 max와 비교해서 큰 값이 있으면 교체하고 교체된 값을 더함
        */
        
        //값, 갯수
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

        for(int i=0; i<enemy.length; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);
            if (n < 0) {
                if (k == 0) {
                    return i;
                }
                n += pq.poll();
                k--;
            }
        }
        return enemy.length;
    }
}