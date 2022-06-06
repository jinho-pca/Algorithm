package Algorithm.Programmers.LEVEL2;

public class Solution_숫자의표현 {
    public int solution(int n) {
        int answer = 1;
        if(n % 2 != 0) answer++;
        for(int i = 3; i < n; i++) {
            if(i % 2 == 0) continue;
            if(n % i == 0) answer++;
        }
        return answer;
    }
}
