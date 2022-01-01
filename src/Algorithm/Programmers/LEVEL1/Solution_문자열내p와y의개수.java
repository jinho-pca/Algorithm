package Algorithm.Programmers.LEVEL1;

public class Solution_문자열내p와y의개수 {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        for(int i =0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            switch(tmp) {
                case 'p': pCnt++;
                    break;
                case 'y': yCnt++;
                    break;
                case 'P': pCnt++;
                    break;
                case 'Y': yCnt++;
            }
        }
        if(pCnt != yCnt) answer = false;

        return answer;
    }
}
