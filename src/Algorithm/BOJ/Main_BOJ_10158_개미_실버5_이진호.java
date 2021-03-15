package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10158_개미_실버5_이진호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		int ty = t;
		int x = 0;
		int y = 0;
		while(t > 2*w) {
			t -= 2*w;
		}
		while(ty >= 2*h) {
			ty -= 2*h;
		}
		if(t <= w-p) {
			x = p + t;
		}else if(t> w-p && t <= 2*(w-p)) {
			x = w - (t-(w-p));
		}else if(2*(w-p) < t && t <= p+ 2*(w-p)) {
			x = p - (t - 2*(w-p));
		}else {
			x = t - (w + (w-p));
		}
		if(ty <= h-q) {
			y = q + ty;
		}else if(ty > h-q && ty <= 2*(h-q)) {
			y = h - (ty-(h-q));
		}else if(2*(h-q) < ty && ty <= q + 2*(h-q)) {
			y = q - (ty - 2*(h-q));
		}else {
			y = ty - (h + (h-q));
		}
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	} // end of main
} // end of class
