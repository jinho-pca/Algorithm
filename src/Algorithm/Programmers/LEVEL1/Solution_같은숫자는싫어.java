package Algorithm.Programmers.LEVEL1;

import java.util.ArrayList;

public class Solution_같은숫자는싫어 {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) continue;
            else list.add(arr[i]);
        }
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
