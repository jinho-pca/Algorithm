package Algorithm.Programmers.LEVEL1;

public class Solution_가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";
        if(s.length() % 2 == 0) {
            answer = s.substring(s.length()/2-1, s.length()/2+1);
        } else answer = answer += s.charAt(s.length() / 2);
        return answer;
    }
}
