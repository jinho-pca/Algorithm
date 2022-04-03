package Algorithm.Programmers.LEVEL1;

import java.util.HashSet;

public class Solution_폰켓몬 {
    public int solution(int[] nums) {
        int kind = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int x : set) kind++;
        return kind > nums.length / 2 ? nums.length / 2 : kind;
    }
}
