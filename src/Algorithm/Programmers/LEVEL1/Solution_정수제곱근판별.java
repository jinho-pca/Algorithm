package Algorithm.Programmers.LEVEL1;

public class Solution_정수제곱근판별 {
    public long solution(long n) {
        long answer = -1;
        double sqrtN = Math.sqrt(n);
        if(sqrtN - (long)sqrtN == 0.0) {
            answer = ((long)sqrtN + 1) * ((long)sqrtN + 1);
        }
        return answer;
    }
}
/*
정수 / 소수 구분방법 : 제곱근은 double형 이므로 long형으로 변환할 경우 소수부분이 제거된다.
그러므로 실제곱근값과 소수부분을 버림한 정수값과의 차이가 존재한다면 소수부분이 존재하는 것과 같으므로
실제곱근은 정수가 아니라는 것이다.
 */