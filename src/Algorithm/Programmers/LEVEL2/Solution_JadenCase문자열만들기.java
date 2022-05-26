package Algorithm.Programmers.LEVEL2;

import java.util.StringTokenizer;

public class Solution_JadenCase문자열만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken();
            for(int i = 0; i < tmp.length(); i++) {
                if(tmp.equals(" ")) {
                    sb.append(" ");
                    continue;
                } else if(i == 0) {
                    sb.append(Character.toUpperCase(tmp.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(tmp.charAt(i)));
                }
            }
        }
        return sb.toString();
    }
}
