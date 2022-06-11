package Algorithm.Programmers.LEVEL2;

import java.util.Arrays;

public class Solution_최솟값만들기 {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int N = A.length;
        for(int i = 0; i < N; i++) {
            answer += A[i] * B[N-1-i];
        }
        return answer;
    }
}
