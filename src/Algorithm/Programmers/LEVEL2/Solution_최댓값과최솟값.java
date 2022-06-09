package Algorithm.Programmers.LEVEL2;

import java.util.StringTokenizer;

public class Solution_최댓값과최솟값 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
        }
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
