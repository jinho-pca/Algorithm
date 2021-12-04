package Algorithm.Programmers.LEVEL1;

public class Solution_제일작은수제거하기 {
    public int[] solution(int[] arr) {
        int len = arr.length;
        int[] answer;
        if (len == 1) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            int min = arr[0];
            int minIdx = -1;
            int idx = 0;
            answer = new int[len-1];
            for(int i = 1; i < len; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                    minIdx = i;
                }
            }
            for(int i = 0; i < len; i++) {
                if(i != minIdx) {
                    answer[idx++] = arr[i];
                } else continue;
            }
        }

        return answer;
    }
}
