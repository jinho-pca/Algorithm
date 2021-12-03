package Algorithm.Programmers.LEVEL1;

public class Solution_자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        String strN = Integer.toString(n);
        for(int i = 0; i < strN.length(); i++) {
            answer += strN.charAt(i) - '0';
        }
        return answer;
    }
}
