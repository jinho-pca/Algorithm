package Algorithm.Programmers.LEVEL1;

import java.util.Arrays;

public class Solution_예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
            if(budget >= d[i]) {
                budget -= d[i];
                answer++;
            } else if(budget == 0) return answer;
            else continue;
        }
        return answer;
    }
}
