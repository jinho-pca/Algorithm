package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9466_텀프로젝트_골드4_이진호 {
    static int TC, N, result;
    static int[] choice;
    static boolean[] visited;
    static boolean[] finish;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            choice = new int[N+1];
            visited = new boolean[N+1];
            finish = new boolean[N+1];
            for (int i = 1; i <= N; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if(!visited[i]) dfs(i);
            }
            sb.append(N - result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static void dfs(int index){
        visited[index] = true;
        int target = choice[index];

        if(!visited[target]) dfs(target);
        else{
            if(!finish[target]){
                result++;
                while(target != index){
                    result++;
                    target = choice[target];
                }
            }
        }
        finish[index] = true;
    }
} // end of class
