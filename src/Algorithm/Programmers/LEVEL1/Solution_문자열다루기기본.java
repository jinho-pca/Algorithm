package Algorithm.Programmers.LEVEL1;

public class Solution_문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6) {
            int a;
            try{
                a = Integer.parseInt(s);
            } catch(NumberFormatException e) {
                answer = false;
            }
        } else answer = false;
        return answer;
    }
}
