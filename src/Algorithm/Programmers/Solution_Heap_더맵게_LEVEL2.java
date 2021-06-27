package Algorithm.Programmers;

import java.util.PriorityQueue;

public class Solution_Heap_더맵게_LEVEL2 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        System.out.print(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K){
        int answer = 0;
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while(pq.size() > 1){
            if(pq.peek() >= K) break;
            answer++;
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + 2 * second);
        }
        if(pq.peek() < K) answer = -1;
        return answer;
    }
}

/*
1072(+12)점

제출코드
import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int answer = 0;
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while(pq.size() > 1){
            if(pq.peek() >= K) break;
            answer++;
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + 2 * second);
        }
        if(pq.peek() < K) answer = -1;
        return answer;
    }
}
 */