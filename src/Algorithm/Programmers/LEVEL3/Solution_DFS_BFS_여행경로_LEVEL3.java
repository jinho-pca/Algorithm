package Algorithm.Programmers.LEVEL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_DFS_BFS_여행경로_LEVEL3 {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    static String route = "";

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.print(Arrays.toString(solution(tickets)));
        ;
    } // end of main

    public static String[] solution(String[][] tickets) {
        int len = tickets.length;
        visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if ("ICN".equals(from)) {
                visited[i] = true;
                route = from + ",";
                dfs(tickets, to, 1);
                visited[i] = false;
            }
        }
        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        return answer;
    } // end of solution
    private static void dfs(String[][] tickets, String to, int cnt){
        int len = tickets.length;
        route += to + ",";
        if(cnt == len){
            list.add(route);
            return;
        }
        for(int i = 0; i < len; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            if(to.equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets, end, cnt+1);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
} // end of class

/*
제출코드
테스트 1 〉	통과 (125.21ms, 77.9MB)
테스트 2 〉	통과 (15.99ms, 53.2MB)
테스트 3 〉	통과 (16.92ms, 53.4MB)
테스트 4 〉	통과 (15.56ms, 53MB)
1087 (+15)

import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    static String route = "";
    public String[] solution(String[][] tickets) {
        int len = tickets.length;
        visited = new boolean[len];

        for(int i = 0; i < len; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            if("ICN".equals(from)){
                visited[i] = true;
                route = from + ",";
                dfs(tickets, to, 1);
                visited[i] = false;
            }
        }
        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        return answer;
    }
    private static void dfs(String[][] tickets, String to, int cnt){
        int len = tickets.length;
        route += to + ",";
        if(cnt == len){
            list.add(route);
            return;
        }
        for(int i = 0; i < len; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            if(to.equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets, end, cnt+1);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}
 */