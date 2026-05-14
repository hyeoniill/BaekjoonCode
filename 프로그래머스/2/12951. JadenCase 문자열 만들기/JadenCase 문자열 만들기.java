class Solution {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        
        for(char c : arr) {
            if(c == ' ') {
                isFirst = true;
            } else {
                if(isFirst && c >= 'a' && c <= 'z') {
                    c -= 32;
                }
                isFirst = false;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}