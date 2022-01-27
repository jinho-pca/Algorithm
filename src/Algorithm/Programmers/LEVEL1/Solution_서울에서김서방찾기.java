package Algorithm.Programmers.LEVEL1;

public class Solution_서울에서김서방찾기 {
    public String solution(String[] seoul) {
        int answer = 0;
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = i;
                break;
            }
        }
        return String.format("김서방은 %d에 있다", answer);
    }
}
