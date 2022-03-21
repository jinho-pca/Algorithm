package Algorithm.Programmers.LEVEL1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        ArrayList<Integer> lostList = new ArrayList<>();
        for(int x : lost) lostList.add(x);
        Arrays.sort(reserve);
        ArrayList<Integer> reserveList = new ArrayList<>();
        for(int y : reserve) reserveList.add(y);

        for(int i = 0; i < reserveList.size(); i++) {
            if(lostList.contains(reserveList.get(i))) {
                int idx = lostList.indexOf(reserveList.get(i));
                lostList.remove(idx);
                reserveList.remove(i);
                i--;
                answer++;
            }
        }

        for(int i = 0; i < reserveList.size(); i++) {
            if(lostList.size() == 0) return answer;
            int r = reserveList.get(i);
            if(lostList.contains(r-1)) {
                int l = lostList.indexOf(r-1);
                lostList.remove(l);
                answer++;
                continue;
            } else if(lostList.contains(r+1)) {
                int l = lostList.indexOf(r+1);
                lostList.remove(l);
                answer++;
                continue;
            } else continue;
        }

        return answer;
    }
}
