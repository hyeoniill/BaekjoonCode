import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int total=0;
        int count=0;
        for(int price : d) {
            total+=price;
            if(total<=budget) count++;
            else break;
        }
        return count;
    }
}