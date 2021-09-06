package DataStructure.DP;

import java.util.Scanner;

/*
5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
-2 0 0 0 2
0 -3 3 1 0


5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
2 0 0 0 2
0 3 3 1 0
*/
/**
 * @author taeheekim
 */
public class DP4_FloydTest {

	static final int INF = 9999999;
	static int N,distance[][];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		distance = new int[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				distance[i][j] = sc.nextInt();
				if(i != j && distance[i][j]==0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
					distance[i][j]=INF;
				}
			}
		}
		System.out.println("===========입력==========");
		print();
        // 출발지-->경유지-->목적지로 3중 루프 돌리면 오답
        // 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
		// k가 늘어날때마다 고려하는 경유지가 하나씩 늘어나는 것이다.
		// 직접경로와 경유지1개를 고려한 거리중 최소가 distance[i][j]에 저장되고 그다음 k에서는 기존 1개의 경유지를 고려한 결과와 1개의 경유지를 추가한 결과를 비교해서 저장한다.
		// 즉 k를 끝까지 돌리게 되면 모든 경유지를 고려한 최단 경로가 저장되게 된다.
		for(int k=0; k<N; ++k) {
			for(int i=0; i<N; ++i) {
				if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
				for(int j=0; j<N; ++j) {
					if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if(distance[i][k]!= INF && distance[k][j] != INF && distance[i][j] > distance[i][k]+distance[k][j]) {
						distance[i][j] = distance[i][k]+distance[k][j];
					}
				}
			}
			print();
		}
	
	}
	private static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(distance[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
	}

}
