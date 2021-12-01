package Algorithm.Programmers.LEVEL1;

public class Solution_x만큼간격이있는n개의숫자 {
    class Solution {
        public long[] solution(long x, int n) {
            long[] answer = new long[n];
            for (int i = 0; i < n; i++) {
                answer[i] = x * (i + 1);
            }
            return answer;
        }
    }
}
