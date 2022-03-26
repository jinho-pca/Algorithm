package Algorithm.Programmers.LEVEL1;

import java.util.StringTokenizer;

public class Solution_이상한문자만들기 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if(tmp.equals(" ")) {
                sb.append(" ");
                continue;
            }
            for(int i = 0; i < tmp.length(); i++) {
                if(i % 2 == 0) {
                    sb.append(Character.toUpperCase(tmp.charAt(i)));
                } else sb.append(Character.toLowerCase(tmp.charAt(i)));
            }
        }
        return sb.toString();
    }
}
