package Algorithm.Programmers.LEVEL2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer;
        int n = progresses.length;
        int[] days = new int[n];
        for(int i = 0; i < n; i++) {
            queue.offer(new int[] {progresses[i], (100-progresses[i]-1) / speeds[i] + 1});
        }

        int[] pick = queue.poll();
        int cnt = 1;
        while(!queue.isEmpty()) {
            if(pick[1] >= queue.peek()[1]) {
                // 선택된 작업이 끝나기전에 후작업이 끝나는 경우 -> 카운트 올린다.
                queue.poll();
                cnt++;
            } else {
                // 선택된 작업이 끝나기전에 후작업이 끝나지 않는 경우 -> 누적된 카운트를 리스트에 넣는다.
                list.add(cnt);
                pick = queue.poll();
                cnt = 1;
            }
        }
        list.add(cnt);
        answer = new int[list.size()];
        int i = 0;
        for(int x : list) {
            answer[i++] = x;
        }
        return answer;
    }
}
