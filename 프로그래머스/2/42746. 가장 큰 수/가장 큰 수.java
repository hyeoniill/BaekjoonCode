import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numbs = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            numbs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numbs, (a, b) -> (b+a).compareTo(a+b));
        
        if(numbs[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(String n : numbs) {
            sb.append(n);
        }
        
        
        return sb.toString();
    }
}