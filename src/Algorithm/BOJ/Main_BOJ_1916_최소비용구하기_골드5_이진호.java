package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기_골드5_이진호 {
    static class Node implements Comparable<Node>{
        int to;
        int cost;

        public Node() {
        }

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int N, M, start, end;
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;
    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        distance = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i <= N; i++) {
            distance[i] = INF;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        System.out.print(distance[end]);
    } // end of main
    private static void dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node cn = pq.poll();
            if(distance[cn.to] < cn.cost) continue;

            for (int i = 0; i < graph[cn.to].size(); i++) {
                Node nn = graph[cn.to].get(i);
                if(distance[nn.to] > distance[cn.to] + graph[cn.to].get(i).cost){
                    distance[nn.to] = distance[cn.to] + graph[cn.to].get(i).cost;
                    pq.add(new Node(nn.to, distance[nn.to]));
                }
            }
        }

    } // end of dijkstra
} // end of clas
