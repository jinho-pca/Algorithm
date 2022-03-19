package Algorithm.Programmers.LEVEL1;

import java.util.HashMap;
import java.util.Map;

public class Solution_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++) {
            if(map.get(participant[i]) != null){ // 이미 map에 존재하는 경우 == 동명이인 발생한 경우
                int cnt = map.get(participant[i]);
                map.put(participant[i], cnt+1);
            } else {
                map.put(participant[i], 1);
            }
        }
        for(int i = 0; i < completion.length; i++) {
            if(map.get(completion[i]) != null) { // 완주자가 참여자 목록에 존재한다면
                int cnt = map.get(completion[i]);
                map.put(completion[i], cnt-1);
            } else {
                answer = completion[i];
                return answer;
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) {
                answer = entry.getKey();
                return answer;
            }
        }
        return answer;
    }
}
