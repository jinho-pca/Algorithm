package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1781_컵라면_골드2_이진호 {
    static class Node implements Comparable<Node>{
        int deadline;
        int cnt;

        public Node(int deadline, int cnt) {
            this.deadline = deadline;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Node o2){
            return this.deadline - o2.deadline;
        }
    }
    static int N;
    static ArrayList<Node> list = new ArrayList<Node>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int result = 0;

        for (int i = 0; i < N; i++) {
            int deadline = list.get(i).deadline;
            int cnt = list.get(i).cnt;
            pq.add(cnt);
            while(!pq.isEmpty() && pq.size() > deadline) pq.poll();
        }
        while(!pq.isEmpty()){
            result += pq.poll();
        }
        System.out.print(result);
    } // end of main
} // end of class
