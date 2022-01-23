package Algorithm.Programmers.LEVEL1;

import java.util.Arrays;

public class Solution_문자열내림차순으로배치하기 {
    public String solution(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(str);
        sb.append(String.valueOf(str));
        sb.reverse();
        return sb.toString();
    }
}
