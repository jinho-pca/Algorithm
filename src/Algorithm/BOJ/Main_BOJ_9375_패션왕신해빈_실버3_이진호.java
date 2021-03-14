package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_9375_패션왕신해빈_실버3_이진호 {
    static int N, result;
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            map.clear();
            N = Integer.parseInt(br.readLine());
            if(N == 0){ // 옷의 종류가 0개면 경우의 수도 0
                result = 0;
                sb.append(result).append("\n");
                continue;
            }
            result = 1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken(); // 옷의 이름은 필요없으니까 날린다.
                String key = st.nextToken(); // 옷의 종류
                if(map.containsKey(key)){ // 같은종류의 다른 옷이 이미 저장되어 있는 경우 그 key에 해당하는 value값을 +1
                    map.put(key, map.get(key) + 1);
                }else{ // 처음 저장되는 옷의 종류인 경우 value 를 1로 저장한다.
                    map.put(key, 1);
                }
            }
            map.forEach((key, value) -> result *= value+1);
            result--; // 아무것도 입지 않는 상태 빼주기
            sb.append(result).append("\n");
        } // end of for testCase
        System.out.print(sb);
    } // end of main
} // end of class
