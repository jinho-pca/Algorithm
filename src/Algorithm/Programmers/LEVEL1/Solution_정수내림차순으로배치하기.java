package Algorithm.Programmers.LEVEL1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_정수내림차순으로배치하기 {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        long answer = 0;
        String strN = Long.toString(n);
        for(int i = 0; i < strN.length(); i++) {
            list.add(strN.charAt(i) - '0');
        }
        Collections.sort(list);
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        strN = sb.toString();
        answer = Long.parseLong(strN);

        return answer;
    }
}
