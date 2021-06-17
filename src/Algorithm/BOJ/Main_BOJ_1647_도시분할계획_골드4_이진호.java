package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1647_도시분할계획_골드4_이진호 {
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node node){
            return this.cost - node.cost;
        }
    }
    static int N, M, cnt, result;
    static Node[] list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new Node[M];
        parent = new int[N+1];
        // make
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // 가중치 오름차순 정렬
        Arrays.sort(list);
        for (Node node : list){
            union(node.from, node.to, node.cost);
            // 2개의 그룹으로 나눠야 하기 때문에 N-2개의 간선만 사용하고 끝낸다.
            if(cnt == N-2) break;
        }
        System.out.print(result);
    } // end of main
    private static void union(int from, int to, int cost){
        from = findSet(from);
        to = findSet(to);
        if(from != to){
            result += cost; // 가중치 합
            cnt++; // 선택한 간선수
            if(from < to) parent[from] = to;
            else parent[to] = from;
        }
    } // end of union
    private static int findSet(int a){
        if(parent[a] == a) return a;
        return parent[a] = findSet(parent[a]);
    } // end of find
} // end of class
