package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
1018(+11)
 */
public class Solution_2019_KAKAO_오픈채팅방_LEVEL2 {
    public static String[] solution(String[] record) {
        String[] answer = {};
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String act, id, nick;
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i], " ");
            act = st.nextToken();
            id = st.nextToken();
            if(st.hasMoreTokens()){
                nick = st.nextToken();
                map.put(id, nick);
                if(act.equals("Enter")){
                    list.add(new String[] {act, id});
                }

            }if(act.equals("Leave")){
                list.add(new String[] {act, id});
            }
        }
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String tmpAct = list.get(i)[0];
            String tmpId = list.get(i)[1];
            sb.append(map.get(tmpId)).append("님이 ");
            if(tmpAct.equals("Enter")){
                sb.append("들어왔습니다.");
                sb = new StringBuilder();
                answer[i] = sb.toString();
            }else if(tmpAct.equals("Leave")){
                sb.append("나갔습니다.");
                answer[i] = sb.toString();
                sb = new StringBuilder();
            }
        }
        return answer;
    }
} // end of class
/*
테스트 1 〉통과 (0.30ms, 54.1MB)
테스트 2 〉통과 (0.23ms, 54.2MB)
테스트 3 〉통과 (0.54ms, 52.2MB)
테스트 4 〉통과 (0.51ms, 52.8MB)
테스트 5 〉통과 (6.38ms, 54.8MB)
테스트 6 〉통과 (7.55ms, 53.7MB)
테스트 7 〉통과 (6.96ms, 53.2MB)
테스트 8 〉통과 (5.60ms, 54MB)
테스트 9 〉통과 (7.87ms, 53.8MB)
테스트 10 〉통과 (11.32ms, 53.8MB)
테스트 11 〉통과 (5.13ms, 54.8MB)
테스트 12 〉통과 (4.01ms, 53.9MB)
테스트 13 〉통과 (7.23ms, 53.7MB)
테스트 14 〉통과 (12.29ms, 54.8MB)
테스트 15 〉통과 (0.16ms, 51.9MB)
테스트 16 〉통과 (0.23ms, 52MB)
테스트 17 〉통과 (2.49ms, 52.7MB)
테스트 18 〉통과 (2.10ms, 52.7MB)
테스트 19 〉통과 (7.45ms, 54.1MB)
테스트 20 〉통과 (16.91ms, 53.8MB)
테스트 21 〉통과 (9.63ms, 54MB)
테스트 22 〉통과 (6.38ms, 53.6MB)
테스트 23 〉통과 (8.02ms, 54.9MB)
테스트 24 〉통과 (9.22ms, 55.1MB)
테스트 25 〉통과 (222.92ms, 141MB)
테스트 26 〉통과 (241.66ms, 155MB)
테스트 27 〉통과 (256.46ms, 161MB)
테스트 28 〉통과 (241.31ms, 159MB)
테스트 29 〉통과 (259.04ms, 157MB)
테스트 30 〉통과 (220.66ms, 142MB)
테스트 31 〉통과 (236.65ms, 157MB)
테스트 32 〉통과 (179.17ms, 143MB)
 */
