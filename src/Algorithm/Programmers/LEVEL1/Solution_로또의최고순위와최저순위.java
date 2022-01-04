package Algorithm.Programmers.LEVEL1;

public class Solution_로또의최고순위와최저순위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int[] score = {6, 6, 5, 4, 3, 2, 1};
            int cnt = 0;
            int correct = 0;
            for(int i = 0; i < 6; i++) {
                if(lottos[i] == 0) cnt++;
            }
            for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 6; j++) {
                    if(lottos[i] == win_nums[j]) correct++;
                }
            }
            answer[0] = score[correct + cnt];
            answer[1] = score[correct];
            return answer;
        }
    }
}
