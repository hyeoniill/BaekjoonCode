class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase()
            .replaceAll("[^a-z0-9-_.]", "")
            .replaceAll("\\.{2,}", ".")
            .replaceAll("^\\.", "").replaceAll("\\.$","");
        
        if(answer.equals("")) answer = "a";
        if(answer.length()>=16) answer = answer.substring(0, 15).replaceAll("\\.$","");
        while(answer.length()<3) answer += answer.charAt(answer.length()-1);
        return answer;
    }
}