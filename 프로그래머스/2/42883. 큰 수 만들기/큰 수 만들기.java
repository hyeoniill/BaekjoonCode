import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        
        // number를 char하나씩 분해해서 계산
        for(char c : number.toCharArray()) {
            // deque가 비어있으면 무조건 추가
            // k개의 숫자를 제거 해야하기 때문에 뺄때마다 k--를 해주어야 함
            // deque의 마지막 자릿수가 현재 c보다 작다면 deque의 뒤부터 숫자를 하나씩 제거
            while(!deque.isEmpty() && k > 0 && deque.peekLast() < c) {
                deque.pollLast();
                k--;
            }
            deque.addLast(c);
        }
        
        
        // 아직 k개 만큼 제거 안 했으면 뒤에서 제거
        while(k > 0) {
            deque.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : deque) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}

