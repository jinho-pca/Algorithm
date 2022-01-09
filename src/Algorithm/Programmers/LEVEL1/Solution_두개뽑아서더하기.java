package Algorithm.Programmers.LEVEL1;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_두개뽑아서더하기 {
    static int[] nums;
    static boolean[] isSelected;
    static HashSet<Integer> set = new HashSet<>();
    public int[] solution(int[] numbers) {
        nums = new int[2];
        isSelected = new boolean[numbers.length];
        permutation(0, numbers);
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int x : set) {
            answer[idx++] = x;
        }
        Arrays.sort(answer);
        return answer;
    }
    private static void permutation(int cnt, int[] numbers) {
        if(cnt == 2) {
            int sum = nums[0] + nums[1];
            set.add(sum);
            return;
        }
        for(int i = 0; i < numbers.length; i++) {
            if(!isSelected[i]) {
                nums[cnt] = numbers[i];
                isSelected[i] = true;
                permutation(cnt + 1, numbers);
                isSelected[i] = false;
            }
        }
    }
}
