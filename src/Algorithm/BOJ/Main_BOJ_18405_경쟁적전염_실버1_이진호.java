package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main_BOJ_18405_경쟁적전염_실버1_이진호 {
    static int N, K, S, X, Y;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp != 0){
                    pq.add(new int[] {tmp, i, j});
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        while(!pq.isEmpty() && S-- > 0){
            int turn = pq.size();
            for (int i = 0; i < turn; i++) {
                spread();
            }
            while(!queue.isEmpty()){
                pq.add(queue.poll());
            }
        }

        System.out.print(map[X][Y]);
    } // end of main
    private static void spread(){
        int[] current = pq.poll();
        for (int i = 0; i < 4; i++) {
            int[] next ={current[0], current[1] + dr[i], current[2] + dc[i]};
            if(next[1] > 0 && next[1] <= N && next[2] > 0 && next[2] <= N){
                if(map[next[1]][next[2]] != 0){
                    continue;
                }else{
                    map[next[1]][next[2]] = next[0];
                    queue.add(next);
                }
            }else continue;
        }
    } // end of spread
} // end of class
