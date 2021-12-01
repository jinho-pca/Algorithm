package Algorithm.Programmers.LEVEL1;

public class Solution_콜라츠추측 {
    public int solution(long num) {
        int answer = 0;

        while(num != 1) {
            answer++;
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            if(answer > 500) return -1;
        }
        return answer;
    }
}
/*
overflow 방지를 위해 int -> long 해야한다.
 */