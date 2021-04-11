package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 모든방 탐색, 최댓값 구해보자 !!
 * @author LG
 *
 */

public class Solution_SWEA_1861_정사각형방_D4_이진호{
	
	private static int N;
	private static int[][] A;
	private static int[][] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N=Integer.parseInt(br.readLine());
			A=new int [N][N];
			memo=new int[N][N]; //탐색할 결과값을 저장할 배열
			
			for(int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					A[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int max=0; //이동할 수 있는 최대 방의 갯수
			int num=-1; //최대 이동을 위해 출발할 방의 위치
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int val=go(r,c);//r,c 위치에서 출발해서 이동할 수 있는 최대 갯수를 return 하는 함수
					if(max<val || max==val && num>A[r][c]) {
						max=val; num=A[r][c];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(num).append(" ").append(max);
			sb.append("\n");
		}//end of tc
		System.out.println(sb.toString());
	}//end of main
	private static int[]dr= {-1,1,0,0}; //상,하,좌,우
	private static int[]dc= {0,0,-1,1};

	public static int go(int r, int c) {
		if(memo[r][c]!=0) { //탐색한 기록이 있는가?
			return memo[r][c];
		}
		//탐색한적이 없이 처음이라면,
		memo[r][c]=1;  //몇 칸 갈수 있는지!
		int num=A[r][c]; //현재 가지고 있는 숫자!!
		for(int i=0; i<4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nc>=0 && nc<N && nr<N && A[nr][nc]==num+1) {//범위내, 이동할수 있냐
				memo[r][c]+=go(nr, nc);
				break; //외길이니까~ 선형!! 이다.  
				//굳이 종료 조건을 걸지않아도, 여기에 해당이안되면 for 문을 나간다.
			}
		}
		
		return memo[r][c];
	}
	
	/**
	 * A[r][c]에서 출발해서 최대 이동할 수 있는 방의 갯수를 리턴하는 메서드!
	 */
	
}
