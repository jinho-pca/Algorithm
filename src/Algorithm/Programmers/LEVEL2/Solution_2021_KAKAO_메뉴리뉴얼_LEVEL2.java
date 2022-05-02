package Algorithm.Programmers.LEVEL2;

import java.util.*;

public class Solution_2021_KAKAO_메뉴리뉴얼_LEVEL2 {
    List<Map<String, Integer>> map = new ArrayList<>();
    int[] maxCnt = new int[11];

    public String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < 11; i++){
            map.add(new HashMap<String, Integer>());
        }

        // 알파벳 순 정렬
        for(String str : orders){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();
        for(int len : course){
            for(Map.Entry<String, Integer> entry : map.get(len).entrySet()){
                if(entry.getValue() >= 2 && entry.getValue() == maxCnt[len]){
                    list.add(entry.getKey());
                }
            }
        }

        // 오름차순 성렬
        Collections.sort(list);

        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void comb(char[] str, int pos, StringBuilder sb){
        if(pos >= str.length){
            int len = sb.length();
            if(len >= 2){
                int cnt = map.get(len).getOrDefault(sb.toString(), 0) + 1;
                map.get(len).put(sb.toString(), cnt);
                maxCnt[len] = Math.max(maxCnt[len], cnt);
            }
            return;
        }
        comb(str, pos+1, sb.append(str[pos])); // 선택 O
        sb.setLength(sb.length()-1); // append 복원
        comb(str, pos+1, sb); // 선택 X
    }
} // end of class

/*
import java.util.*;
class Solution {
    List<Map<String, Integer>> map = new ArrayList<>();
    int[] maxCnt = new int[11];

    public String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < 11; i++){
            map.add(new HashMap<String, Integer>());
        }

        // 알파벳 순 정렬
        for(String str : orders){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();
        for(int len : course){
            for(Map.Entry<String, Integer> entry : map.get(len).entrySet()){
                if(entry.getValue() >= 2 && entry.getValue() == maxCnt[len]){
                    list.add(entry.getKey());
                }
            }
        }

        // 오름차순 성렬
        Collections.sort(list);

        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void comb(char[] str, int pos, StringBuilder sb){
        if(pos >= str.length){
            int len = sb.length();
            if(len >= 2){
                int cnt = map.get(len).getOrDefault(sb.toString(), 0) + 1;
                map.get(len).put(sb.toString(), cnt);
                maxCnt[len] = Math.max(maxCnt[len], cnt);
            }
            return;
        }
        comb(str, pos+1, sb.append(str[pos])); // 선택 O
        sb.setLength(sb.length()-1); // append 복원
        comb(str, pos+1, sb); // 선택 X
    }
}
 */