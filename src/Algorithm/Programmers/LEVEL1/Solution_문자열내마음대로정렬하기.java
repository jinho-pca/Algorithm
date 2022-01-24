package Algorithm.Programmers.LEVEL1;

import java.util.Arrays;

public class Solution_문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (String o1, String o2) -> {
            int diff = o1.charAt(n) - o2.charAt(n);
            return diff == 0 ? o1.compareTo(o2) : diff;
        });
        return strings;
    }
}
