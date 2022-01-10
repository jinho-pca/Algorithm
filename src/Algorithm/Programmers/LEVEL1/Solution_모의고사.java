package Algorithm.Programmers.LEVEL1;

import java.util.ArrayList;

public class Solution_모의고사 {
    public int[] solution(int[] answers) {
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] answer;
        int[] score = new int[3];
        for(int i = 0; i < answers.length; i++) {
            int tmp = answers[i];
            // 1번 학생
            int score1 = i % 5;
            if(tmp == student1[score1]) { // 정답
                score[0]++;
            }
            int score2 = i%2 != 0 ? i % 8 : 2;
            if(tmp == student2[score2]) { // 정답
                score[1]++;
            }
            int score3 = i % 10;
            if(tmp == student3[score3]) { // 정답
                score[2]++;
            }
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(score[0] == max) list.add(1);
        if(score[1] == max) list.add(2);
        if(score[2] == max) list.add(3);
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
