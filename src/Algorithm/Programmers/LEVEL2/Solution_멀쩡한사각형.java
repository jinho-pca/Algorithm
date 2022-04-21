package Algorithm.Programmers.LEVEL2;

public class Solution_멀쩡한사각형 {
    static long cnt;
    public long solution(int w, int h) {
        long answer = 0;

        for(int i = 1; i <= w; i++) {
            long depth = 0;
            double real = graph(i, w, h); // 교점의 y좌표
            double ceil = Math.ceil(real); // 교점의 y좌표의 올림값
            if(real == ceil) { // 교점의 y좌표가 정수인 경우
                depth = (long)h - (long)real;
            } else {
                depth = (long)h - (long)ceil;
            }
            answer += depth;
            if(depth == 0) break;
        }

        return answer * 2;
    }
    private static double graph(int x, int w, int h) {
        return ((double) h/ (double) w) * (double)x;
    }
}
