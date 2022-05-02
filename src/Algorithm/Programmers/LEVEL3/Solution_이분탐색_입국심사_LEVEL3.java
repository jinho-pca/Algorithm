package Algorithm.Programmers.LEVEL3;

import java.util.Arrays;

public class Solution_이분탐색_입국심사_LEVEL3 {
    public static void main(String[] args) {
        System.out.print(solution(6, new int[] {7, 10}));
    } // end of main
    private static long solution(int n, int[] times){
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long start = times[0];
        long end = (long) times[times.length - 1] * (long) n;
        long mid;
        long sum = 0;
        while(start <= end){
            mid = (start + end) / 2;
            sum = 0;
            for(int time : times) sum+= mid/time;
            if(sum >= n){
                answer = answer < mid ? answer : mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return answer;
    } // end of solution
} // end of class
/*
1124 (+13)
제출코드

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long start = times[0];
        long end = (long) times[times.length - 1] * (long) n;
        long mid;
        long sum = 0;
        while(start <= end){
            mid = (start + end) / 2;
            sum = 0;
            for(int time : times) sum+= mid/time;
            if(sum >= n){
                answer = answer < mid ? answer : mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        return answer;
    }
}
 */
/*
테스트 1 〉	통과 (1.41ms, 51.7MB)
테스트 2 〉	통과 (0.55ms, 53.5MB)
테스트 3 〉	통과 (2.29ms, 52.7MB)
테스트 4 〉	통과 (125.98ms, 61.3MB)
테스트 5 〉	통과 (86.23ms, 59.3MB)
테스트 6 〉	통과 (104.32ms, 60.2MB)
테스트 7 〉	통과 (148.26ms, 59.7MB)
테스트 8 〉	통과 (144.07ms, 60.8MB)
테스트 9 〉	통과 (0.44ms, 51.7MB)
 */