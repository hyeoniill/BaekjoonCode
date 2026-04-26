import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        //이미 나온 단어 저장용, 순서는 필요 없기 때문에 SET
        Set<String> set = new HashSet<>();
        String currentWord = words[0];
        if(currentWord.length() == 1) {
            return answer;
        } else {
            set.add(currentWord);
        }

        for(int i=1; i<words.length; i++) {
            currentWord = words[i];
            if(currentWord.length() == 1 || currentWord.charAt(0) != words[i-1].charAt(words[i-1].length()-1) || set.contains(currentWord)) {
                answer[0] = (i%n)+1;
                //index가 0부터 있기 때문에 (i/n)+1로 순서를 해도 9번째=8번이므로 가능
                answer[1] = (i/n)+1;
                break;
            }
                set.add(currentWord);    
        }

        return answer;
    }
}