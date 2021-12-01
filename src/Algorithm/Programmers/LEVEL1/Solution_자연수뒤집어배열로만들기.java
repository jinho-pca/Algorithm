package Algorithm.Programmers.LEVEL1;

public class Solution_자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        String strN = Long.toString(n);
        int len = strN.length();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = strN.charAt(len -1 - i) - '0';
        }
        return answer;
    }
}
