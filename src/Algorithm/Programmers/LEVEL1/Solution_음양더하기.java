package Algorithm.Programmers.LEVEL1;

public class Solution_음양더하기 {
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            int[] numbers = new int[absolutes.length];
            for(int i = 0; i < absolutes.length; i++) {
                if(!signs[i]) {
                    numbers[i] = absolutes[i] * -1;
                } else numbers[i] = absolutes[i];
            }
            for(int i = 0; i < numbers.length; i++) {
                answer += numbers[i];
            }
            return answer;
        }
    }
}
