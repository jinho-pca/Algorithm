package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2527_직사각형_실버1_이진호 {
	static class Rect{
		private int sx;
		private int sy;
		private int ex;
		private int ey;
		private int width;
		private int height;
		public Rect(int sx, int sy, int ex, int ey) {
			super();
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
			this.width = ex - sx;
			this.height = ey - sy;
		}
		
	}
	static char result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= 4; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Rect r1 = new Rect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Rect r2 = new Rect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int wLength = Math.max(r1.ex, r2.ex) - Math.min(r1.sx, r2.sx); // 영역의 가로양끝거리
			int hLength = Math.max(r1.ey, r2.ey) - Math.min(r1.sy, r2.sy); // 영역의 가로양끝거리
			if(r1.width + r2.width == wLength || r1.height + r2.height == hLength) { // result == b or c
				if(r1.width + r2.width == wLength && r1.height + r2.height == hLength) {
					result = 'c';
				}else {
					result = 'b';
				}
			}else if(r1.width + r2.width < wLength || r1.height + r2.height < hLength) {
				result = 'd';
			}else {
				result = 'a';
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}