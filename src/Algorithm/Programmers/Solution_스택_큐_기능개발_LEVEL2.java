package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_스택_큐_기능개발_LEVEL2 {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.print(Arrays.toString(solution(progresses, speeds)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int N = progresses.length;
        for(int i = 0; i < N; i++){
            queue.offer((100 - progresses[i] - 1) / speeds[i] + 1);
        }
        int day = 1;
        int left = queue.poll();
        while(!queue.isEmpty()){
            int right = queue.poll();
            if(left >= right){
                day++;
            }else{
                result.add(day);
                day = 1;
                left = right;
            }
        }
        result.add(day);
        int M = result.size();
        answer = new int[M];
        for(int i = 0; i < M; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

/*
1140(+6)

제출코드

import java.util.*;
class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int N = progresses.length;
        for(int i = 0; i < N; i++){
            queue.offer((100 - progresses[i] - 1) / speeds[i] + 1);
        }
        int day = 1;
        int left = queue.poll();
        while(!queue.isEmpty()){
            int right = queue.poll();
            if(left >= right){
                day++;
            }else{
                result.add(day);
                day = 1;
                left = right;
            }
        }
        result.add(day);
        int M = result.size();
        answer = new int[M];
        for(int i = 0; i < M; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
 */
