package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_3040_백설공주와일곱난쟁이_브론즈2_이진호 {
	static int[] dwarf = new int[9];
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			sum += dwarf[i] = Integer.parseInt(br.readLine());
		}
x:		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if(dwarf[i] + dwarf[j] == sum-100) {
					dwarf[i] = dwarf[j] = 0;
					i = 9;
					break x;
				}
			}
		}
		for(int i : dwarf) {
			if(i != 0) {
				System.out.println(i);
			}
		}
	}
}
