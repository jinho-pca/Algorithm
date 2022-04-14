package Algorithm.Programmers.LEVEL1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        // 유저별 신고 유무를 체크하기 위한 2차원 배열
        boolean[][] check = new boolean[n][n];
        HashMap<String, Integer> reportMap = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        // 신고횟수를 저장하기 위한 HashMap 생성 및 유저 수만큼 만들어 신고횟수를 0으로 초기화 및 인덱스맵에 인덱스 저장
        for(int i = 0; i < n; i++) {
            indexMap.put(id_list[i], i);
            reportMap.put(id_list[i], 0);
        }

        // report 순회하면서 Map에 신고횟수 추가하면서 a가 b를 신고한 경우 a의 배열에 b 부분 true로 변경
        // 이렇게 하기 위해서는 a로 a의 인덱스를 반환할 수 있어야 한다.
        // 신고자와 피신고자를 구분하기 위한 StringTokenizer
        StringTokenizer st;
        for(int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i], " ");
            String er = st.nextToken(); // 신고자
            String ee = st.nextToken(); // 피신고자
            int erIdx = indexMap.get(er); // 신고자 인덱스
            int eeIdx = indexMap.get(ee); // 피신고자 인덱스
            // 신고자가 피신고자를 신고한 적이 있다면 패스
            if(check[erIdx][eeIdx]) continue;
            // 신고자가 피신고자를 신고한 적이 없다면 체크 및 신고횟수 증가
            check[erIdx][eeIdx] = true; // 체크
            int cnt = reportMap.get(ee); // 신고횟수 추출
            reportMap.put(ee, cnt+1); // 신고횟수 증가
        }

        // 정지당하는 유저를 추출한다.
        HashSet<String> suspensionSet = new HashSet<>();
        for(Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            if(entry.getValue() >= k) {
                suspensionSet.add(entry.getKey());
            }
        }

        // check 순회하면서 true인 원소가 suspensionList에 있다면 카운트 해서 배열에 저장
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(!check[i][j]) continue;
                if(suspensionSet.contains(id_list[j])) {
                    // 신고자가 피신고자를 신고했고, 피신고자가 정지목록에 존재하는 경우
                    cnt++;
                } else continue;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
