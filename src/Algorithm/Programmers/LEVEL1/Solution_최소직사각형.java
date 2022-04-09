package Algorithm.Programmers.LEVEL1;

public class Solution_최소직사각형 {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        // 가로길이가 더 크게 회전시키기
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        for(int i = 0; i < sizes.length; i++) {
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }
        return maxW * maxH;
    }
}
