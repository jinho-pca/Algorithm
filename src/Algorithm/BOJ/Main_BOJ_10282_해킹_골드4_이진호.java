package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_10282_해킹_골드4_이진호 {
    static int TC, N, D, C, cnt, result;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            cnt = 0;
            result = 0;
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N+1];
            distance = new int[N+1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            Arrays.fill(distance, Integer.MAX_VALUE);
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new Node(a, s));
            }
            dijkstra(C);
            sb.append(cnt).append(" ").append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int i = 0; i < graph[cur.to].size(); i++) {
                Node pick = graph[cur.to].get(i);
                if(distance[pick.to] > distance[cur.to] + pick.cost) {
                    distance[pick.to] = distance[cur.to] + pick.cost;
                    pq.offer(new Node(pick.to, distance[pick.to]));
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if(distance[i] != Integer.MAX_VALUE) {
                cnt++;
                result = Math.max(result, distance[i]);
            }
        }
    }
} // end of class
