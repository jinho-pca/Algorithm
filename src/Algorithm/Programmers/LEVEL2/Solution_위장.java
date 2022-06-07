package Algorithm.Programmers.LEVEL2;

import java.util.HashMap;
import java.util.Map;

public class Solution_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                int tmp = map.get(clothes[i][1]);
                map.put(clothes[i][1], tmp+1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            answer *= (val+1);
        }

        return --answer;
    }
}
