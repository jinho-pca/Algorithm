package Algorithm.Programmers.LEVEL1;

import java.util.Arrays;

public class Solution_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int from = commands[i][0]-1;
            int to = commands[i][1]-1;
            int pick = commands[i][2]-1;
            int[] tmp = new int[to - from + 1];
            for(int j = 0; j < tmp.length; j++) {
                tmp[j] = array[from + j];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[pick];
        }
        return answer;
    }
}
