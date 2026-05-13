class Solution {
    boolean solution(String s) {

        return s.chars().filter(c -> c=='P' | c=='p').count() == s.chars().filter(c -> c=='Y'| c=='y').count();
    }
}