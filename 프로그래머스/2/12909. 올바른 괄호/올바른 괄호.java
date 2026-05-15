class Solution {
    boolean solution(String s) {
        int count = 0;
        
        for(char c : s.toCharArray()) {
            count = c=='(' ? count+1 : count-1;
            if(count<0) return false;
        }

        return count==0;
    }
}