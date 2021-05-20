package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
235 ms
Priority Queue => 더 느림
최소 신장 트리
정점 : 섬
간선 : 해저터널
<<입력제한>>
섬의개수 : 1 <= N <= 1000
간선의 개수 : N * (N - 1) / 2
가중치 : 해저터널의 길이의 제곱 * 환경부담세율
x, y좌표 : 0<= x, y <=1000000 => 해저터널의 길이 : 100만의 제곱이상 => int형으로 불가 => long(8byte)
=> 8Byte * 인접행렬(1000 * 1000)Byte => 8MB => 메모리 걱정 없다.
밀집그래프 문제 => 인접행렬 : 1000 * 1000 = 1000000
Prim 이 유리하다

1. 입력으로 들어오는 섬의 좌표를 이용하여 간선비용 계산
2. MST 알고리즘 적용(Prim, Kruskal)
Prim : 정점을 중심으로 풀어나가는 방법(인접행렬, 인접리스트)
Kruskal : 간선을 중심으로 풀어나가는 방법(간선리스트) : V^2 * log(V^2)
일반적으로 크루스칼이 더 편한것 같지만 더 느림

그래프 자료구조
1. 인접행렬 : 밀집그래프일때 좀 더 유리
2. 인접리스트 : 희소그래프일때 좀 더 유리
3. 간선리스트

그래프 종류
1. 희소 그래프 : 정점의 개수에 비해 상대적으로 간선의 개수가 적은 그래프 : 인접리스트가 유리
2. 밀집 그래프 : 정점의 개수에 비해 상대적으로 간선의 개수가 많은 그래프 : 인접행렬이나 인접리스트나 비슷
 */
public class Solution_SWEA_1251_하나로_D4_이진호_PQ {
    private static int N;
    private static long[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            N = Integer.parseInt(br.readLine());
            adjMatrix = new long[N][N];
            int[] x = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) { // 각 섬의 x좌표 값
                x[i] = Integer.parseInt(st.nextToken());
            }
            int[] y = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) { // 각 섬의 y좌표 값
                y[i] = Integer.parseInt(st.nextToken());
            }

            // 인접행렬 구성
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adjMatrix[i][j] = adjMatrix[j][i] = getDistance(x[i], x[j], y[i], y[j]);
                }
            }
            double E = Double.parseDouble(br.readLine());
            sb.append("#").append(testCase).append(" ").append(Math.round(makeMST()*E)).append("\n");
//            System.out.println("#" + testCase + " " + Math.round(makeMST()*E));
        } // end of for testCase
        System.out.println(sb);
    } // end of main

    private static long makeMST() {
        long[] minEdge = new long[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(minEdge, Long.MAX_VALUE);
        // 임의의 정점을 시작점으로 만듦
        minEdge[0] = 0;

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.offer(new Vertex(0, minEdge[0]));

        long result = 0; // 최소신장트리 비용
        int cnt = 0; // 정점의 개수

        // 정점 : V, 간선 : E => while문 : V번 탐색, for문 : PQ : V * logV => O(V^2)logV
        while(true){
            // 신장트리에 포함되지 않은 정점 중 최소 간선 비용의 정점을 선택
            Vertex minVertex = queue.poll();
            if(visited[minVertex.no]) continue; // PQ 에 같은 정점의 다른 비용들이 들어있어서 : 삭제를 추가하지 않아서
            // 신장트리에 포함시킴 => PQ
            visited[minVertex.no] = true;
            result += minVertex.cost;
            if(++cnt == N) break;

            for (int i = 0; i < N; i++) {
                if(!visited[i] && minEdge[i] > adjMatrix[minVertex.no][i]){
                    minEdge[i] = adjMatrix[minVertex.no][i];
                    queue.offer(new Vertex(i, minEdge[i]));
                }
            }
        }
        return result;
    } // end of makeMST

    private static long getDistance(int x1, int x2, int y1, int y2){
        return (long) (Math.pow((x1 - x2),2) + Math.pow((y1 - y2), 2));
    } // end of getDistance

    private static class Vertex implements Comparable<Vertex>{
        int no; // 정점의 번호
        long cost; // 간선비용

        public Vertex(int no, long cost) {
            this.no = no;
            this.cost = cost;
        }
        @Override
        public int compareTo(Vertex o){
            return Long.compare(this.cost, o.cost);
        }
    }
} // end of class

/*
Prim 알고리즘 : 정점을 중심으로 해결
a-b : 10
a-c : 5
a-d : 15
b-c : 6
b-d : 20
c-d : 17

1. 임의의 정점 선택 출발 (A)
다른정점에서 자신과 연결하는 간선 비용의 최솟값을 저장하는 배열 생성
 A,  B,   C,   D
[0, max, max, max]
[f,  f,   f,   f] : visited
// 2-1, 2-2 반복(N번)
2-1. MST에 포함되지 않은 정점 중 간선비용이 최소인 정점 선택 (A) => PQ 접목
[0, max, max, max]
[t,  f,   f,   f] : visited
2-2. 해당 정점에서 연결할 수 있는 정점(신장트리에 포함되지 않은 정점만)으로의 간선비용을 기존 최소값과 비교하여 갱신
 A,  B,   C,   D
[0, 10, max, max]
 A,  B,  C,   D
[0, 10, 5, max]
 A,  B,   C,   D
[0, 10, 5, 15]
2번째 루프 : C 선택
 A, B, C, D
[0, 6, 5, 15]
3번째 루프 : B 선택
 A, B, C, D
[0, 6, 5, 15]
 */