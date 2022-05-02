package Algorithm.Programmers.LEVEL2;

import java.util.HashMap;

public class Solution_2018_KAKAO_1차뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 1;
        int common = 0;
        int union = 0;
        HashMap<String, Integer> mapA = new HashMap<>();
        mapA.put("1", 0);
        HashMap<String, Integer> mapB = new HashMap<>();
        mapB.put("1", 0);

        for(int i = 0; i < str1.length()-1; i++) {
            String tmp = str1.substring(i, i+2);
            tmp = tmp.toLowerCase();
            if(tmp.charAt(0) >= 97 && tmp.charAt(0) <= 122 && tmp.charAt(1) >= 97 && tmp.charAt(1) <= 122) {
                if(mapA.get(tmp) == null) {
                    mapA.put(tmp, 1);
                } else {
                    int cnt = mapA.get(tmp);
                    mapA.put(tmp, cnt+1);
                }
            }
        }
        for(int i = 0; i < str2.length()-1; i++) {
            String tmp = str2.substring(i, i+2);
            tmp = tmp.toLowerCase();
            if(tmp.charAt(0) >= 97 && tmp.charAt(0) <= 122 && tmp.charAt(1) >= 97 && tmp.charAt(1) <= 122) {
                if(mapB.get(tmp) == null) {
                    mapB.put(tmp, 1);
                } else {
                    int cnt = mapB.get(tmp);
                    mapB.put(tmp, cnt+1);
                }
            }
        }

        for(String key : mapA.keySet()) {
            if(mapB.containsKey(key)) { // A에서 선택한 키를 B도 가지고 있는경우 -> 교집합은 작은값, 합집합은 큰값
                int cntA = mapA.get(key);
                int cntB = mapB.get(key);
                common += Math.min(cntA, cntB);
                union += Math.max(cntA, cntB);
            } else { // A에서 선택한 키를 B에서 가지고 있지 않은 경우 -> 교집합은 그대로, 합집합은 A의 값을 추가
                union += mapA.get(key);
            }
        }

        // 여기까지 문제점 : B에서 선택한 애가 A에 없는경우
        for(String key : mapB.keySet()) {
            if(!mapA.containsKey(key)) {
                union += mapB.get(key);
            }
        }

        double tmpResult = 0;
        if(common == 0 && union == 0) {
            tmpResult = 1;
        } else {
            tmpResult = (double) common / union;
        }

        answer = (int) (tmpResult * 65536);
        return answer;
    }
}
