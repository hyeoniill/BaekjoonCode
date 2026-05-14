import java.lang.*;
class Solution {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        
        for(char c : arr) {
            sb.append(isFirst ? Character.toUpperCase(c) : c);
            isFirst = c == ' ' ? true : false;
        }
        
        return sb.toString();
    }
}