package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_2109_순회강연_골드4_이진호 {
    static int N, result;
    static boolean[] day = new boolean[10001];
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o2[0] - o1[0];
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        day[0] = true;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(!day[cur[1]]) {
                day[cur[1]] = true;
                result += cur[0];
            }else{
                for (int i = cur[1] -1; i > 0; i--) {
                    if(!day[i]) {
                        day[i] = true;
                        result += cur[0];
                        break;
                    }
                }
            }
        }
        System.out.print(result);
    } // end of main
} // end of class

/*
@Override
        public int compare(int[] o1, int[] o2) {
            if(o1[1] == o2[1]){
                return o2[0] - o1[0];
            }else return o1[1] - o2[1];
        }

result = pq.peek()[0];
        day = pq.poll()[1];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(day == cur[1]){
                continue;
            }else {
                result += cur[0];
                day = cur[1];
            }
        }
 */