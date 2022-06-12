package Algorithm.Programmers.LEVEL2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            q.offer(new int[] {i, priorities[i]});
        }

        while(!q.isEmpty()) {
            boolean flag = false;
            int[] pick = q.poll();
            for(int[] x : q) {
                if(pick[1] < x[1]) {
                    flag = true;
                }
            }
            if(flag) {
                q.offer(pick);
            } else {
                answer++;
                if(pick[0] == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}
