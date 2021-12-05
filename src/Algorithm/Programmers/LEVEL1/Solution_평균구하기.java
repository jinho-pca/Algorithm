package Algorithm.Programmers.LEVEL1;

public class Solution_평균구하기 {
    public double solution(int[] arr) {
        double answer = 0;
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            answer += arr[i];
        }
        return answer / len;
    }
}
