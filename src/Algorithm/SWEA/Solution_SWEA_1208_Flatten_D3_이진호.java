package Algorithm.SWEA;
/**
 * Solution_SWEA_1208_Flatten_D3
 * 1차워 배열로 상자의 높이를 카운팅해서 저장(메모리절약, 시간절약 가능)
 * 가장 높은 칸의 상자 -> 가장 낮은 칸으로 이동 (max, min 변수를 활용해서 시간 절약)
 * 덤프 작업 반복 (덤프회수를 다 쓰기까지, 평탄화가 완료될 때까지)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1208_Flatten_D3_이진호 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine()); // 덤프회수 1 <= N <= 1000
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 델리미터를 넣어주는 것이 더 빠르다.
			
			int[] cnt = new int[101]; // 상자의 높이를 카운팅할 배열, 연산수를 줄일 수 있다. 인덱스랑 층수를 맞추면 -> 인덱스 0 사용안함
			int max = 1; // 1 <= 상자높이 <= 100
			int min = 100;
			int sum = 0; // 상자의 총 개수
			for(int i = 0; i < 100; i++) { // 입력받기
				int x = Integer.parseInt(st.nextToken());
				cnt[x]++;
				if(max < x) max = x;
				if(min > x) min = x;
				sum += x;
			}
			int target = 1; // 평탄화 작업의 목표치 (최대 - 최소)
			if(sum % 100 == 0) {
				target = 0;
			}
			for(int i = 0; i < n && max -min > target; i++) { // 덤프, 평탄화작업의 목표에 도달하면 종료
				cnt[max]--; // 가장 높은 박스를 하나 뺌
				cnt[max-1]++; // 한 박스 뺐으니까 한칸 낮은층 추가
				cnt[min]--; // 가장 낮은 위치에 박스를 쌓을거니까 낮은높이칸수가 하나 없어짐
				cnt[min+1]++; // 박스 하나 쌓은 높이가 생김
				if(cnt[max] == 0) max--;
				if(cnt[min] == 0) min++;
			}
			sb.append("#").append(testCase).append(" ").append(max-min).append("\n");
		} // end of for testCase
		System.out.print(sb);
	} // end of main
} // end of class

/**
 * 이차원배열로도 풀어볼 것!
 * 
 */