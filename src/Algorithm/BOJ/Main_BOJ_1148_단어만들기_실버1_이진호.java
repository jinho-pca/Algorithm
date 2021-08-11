package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1148_단어만들기_실버1_이진호 {
    static int index, min, max;
    static int[][] charArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder minsb;
        StringBuilder maxsb;
        charArr = new int[200000][26];
        String word = br.readLine();
        while(!word.equals("-")){
            for (int i = 0; i < word.length(); i++) {
                charArr[index][word.charAt(i) - 'A']++;
            }
            index++;
            word = br.readLine();
        }

        String puzzle = br.readLine();
        while(!puzzle.equals("#")){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            int[] puzzleArr = new int[26]; // 9개의 문자가 섞인 문자열의 알파벳 개수를 담을 배열
            int[] resultArr = new int[26]; // 만들 수 있는 모든 단어에서 알파벳 개수를 담을 배열
            minsb = new StringBuilder();
            maxsb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                puzzleArr[puzzle.charAt(i) - 'A']++;
            }

    loop1 : for (int i = 0; i < index; i++) {
                for (int j = 0; j < 26; j++) {
                    if(puzzleArr[j] < charArr[i][j]) continue loop1;
                }
                for (int j = 0; j < 26; j++) {
                    if(charArr[i][j] > 0) resultArr[j]++;
                }
            }

            for (int i = 0; i < 26; i++) {
                if(resultArr[i] != 0) min = Math.min(min, resultArr[i]);
                if(resultArr[i] == 0 && puzzleArr[i] > 0) min = 0;
                max = Math.max(max, resultArr[i]);
            }

            for (int i = 0; i < 26; i++) {
                if(min != 0 && min == resultArr[i]){
                    minsb.append((char) (i + 'A'));
                }else if(min == 0 && puzzleArr[i] > 0 && resultArr[i] == 0){
                    minsb.append((char) (i + 'A'));
                }
                if(max == resultArr[i] && puzzleArr[i] > 0){
                    maxsb.append((char) (i + 'A'));
                }
            }
            minsb.append(" ").append(min).append(" ").append(maxsb).append(" ").append(max).append("\n");
            System.out.print(minsb);
            puzzle = br.readLine();
        }
    } // end of main
} // end of class
