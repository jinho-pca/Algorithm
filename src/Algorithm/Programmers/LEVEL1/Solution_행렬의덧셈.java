package Algorithm.Programmers.LEVEL1;

public class Solution_행렬의덧셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = arr1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
