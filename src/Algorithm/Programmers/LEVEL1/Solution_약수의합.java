package Algorithm.Programmers.LEVEL1;

public class Solution_약수의합 {
    public int solution(int n) {
        int answer = 0;
        if(n == 0) return 0;
        if(n == 1) return 1;

        for(int i = 1; i < Math.sqrt(n) + 1; i++) {
            if(n % i == 0) {
                if(n/i != i) {
                    answer += n / i;
                    answer += i;
                }else answer += i;

            }
        }
        return answer;
    }
}
