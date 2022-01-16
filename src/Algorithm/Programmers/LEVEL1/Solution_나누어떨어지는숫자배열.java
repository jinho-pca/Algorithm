package Algorithm.Programmers.LEVEL1;

import java.util.PriorityQueue;

public class Solution_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                pq.offer(arr[i]);
            }
        }
        if(pq.isEmpty()) return new int[] {-1};
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }

        return answer;
    }
}
