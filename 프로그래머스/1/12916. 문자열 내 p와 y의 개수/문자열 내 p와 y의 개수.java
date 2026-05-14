class Solution {
    boolean solution(String s) {
        return s.toLowerCase().chars().map(c->c=='p'?1:c=='y'?-1:0).sum()==0;
    }
}