package Algorithm.Programmers.LEVEL1;

public class Solution_두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        if(a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        } else if(a == b) return a;

        answer = ((long)(a + b) * (b-a+1)) / 2;
        return answer;
    }
}
