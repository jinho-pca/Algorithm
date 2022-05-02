package Algorithm.Programmers.LEVEL3;

public class Solution_DFS_BFS_네트워크_LEVEL3 {
    static boolean[] visited;
    public static void main(String[] args){
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        int n = computers.length;
        System.out.print(solution(n, computers));;
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, n, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    private static void dfs(int start, int n, int[][] computers, boolean[] visited){
        visited[start] = true;
        for(int i = 0; i < n; i++){
            if(!visited[i] && computers[start][i] == 1) dfs(i, n, computers, visited);
        }
    }
}

/*
1060(+10)점

제출 코드
import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, n, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    private static void dfs(int start, int n, int[][] computers, boolean[] visited){
        visited[start] = true;
        for(int i = 0; i < n; i++){
            if(!visited[i] && computers[start][i] == 1) dfs(i, n, computers, visited);
        }
    }
}
 */