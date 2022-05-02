package Algorithm.Programmers.LEVEL3;

import java.util.PriorityQueue;

public class Solution_Heap_디스크컨트롤러_LEVEL3 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    } // end of main
    static class Job implements Comparable<Job>{
        int jobRequest;
        int jobLength;
        Job(int jobRequest, int jobLength){
            this.jobRequest = jobRequest;
            this.jobLength = jobLength;
        }
        @Override
        public int compareTo(Job j){
            return this.jobLength - j.jobLength;
        }
    }
    static PriorityQueue<Job> pq = new PriorityQueue<>();
    static int time, cnt;
    static boolean[] visited;
    public static int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        visited = new boolean[len];

        while(cnt < len){
            for(int i = 0; i < len; i++){
                if(jobs[i][0] <= time && !visited[i]){
                    pq.offer(new Job(jobs[i][0], jobs[i][1]));
                    visited[i] = true;
                }
            }
            if(!pq.isEmpty()){
                Job tmpJob = pq.poll();
                cnt++;
                answer += tmpJob.jobLength + (time - tmpJob.jobRequest);
                time += tmpJob.jobLength;
            } else time++;
        }
        return answer / len;
    }
} // end of class

/*
1101 (+14)
제출코드

import java.util.*;
class Solution {
    static class Job implements Comparable<Job>{
        int jobRequest;
        int jobLength;
        Job(int jobRequest, int jobLength){
            this.jobRequest = jobRequest;
            this.jobLength = jobLength;
        }
        @Override
        public int compareTo(Job j){
            return this.jobLength - j.jobLength;
        }
    }
    static PriorityQueue<Job> pq = new PriorityQueue<>();
    static int time, cnt;
    static boolean[] visited;
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        visited = new boolean[len];

        while(cnt < len){
            for(int i = 0; i < len; i++){
                if(jobs[i][0] <= time && !visited[i]){
                    pq.offer(new Job(jobs[i][0], jobs[i][1]));
                    visited[i] = true;
                }
            }
            if(!pq.isEmpty()){
                Job tmpJob = pq.poll();
                cnt++;
                answer += tmpJob.jobLength + (time - tmpJob.jobRequest);
                time += tmpJob.jobLength;
            } else time++;
        }
        return answer / len;
    }
}
 */