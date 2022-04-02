package Algorithm.Programmers.LEVEL1;

public class Solution_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] currentL = {3, 0}; // 현재 왼손 위치
        int[] currentR = {3, 2}; // 현재 오른손 위치
        for(int i = 0; i < numbers.length; i++) {
            int nextR = (numbers[i] - 1) / 3; // 가야할 위치 행
            int nextC = (numbers[i] - 1) % 3; // 가야할 위치 열
            if(numbers[i] == 0) {
                nextR = 3;
                nextC = 1;
            }

            if(nextC == 0) {
                answer += "L";
                currentL[0] = nextR;
                currentL[1] = nextC;
            } else if(nextC == 2) {
                answer += "R";
                currentR[0] = nextR;
                currentR[1] = nextC;
            } else {
                // 왼손거리 : 가야할 위치 행 - 현재왼손 위치 행 + 가야할 위치 열 - 현재왼손 위치 열
                int deltaL = Math.abs(nextR - currentL[0]) + Math.abs(nextC - currentL[1]);
                // 오른손거리 : 가야할 위치 행 - 현재오른손 위치 행 + 가야할 위치 열 - 현재오른손 위치 열
                int deltaR = Math.abs(nextR - currentR[0]) + Math.abs(nextC - currentR[1]);
                System.out.println(i + " " + deltaL + " " + deltaR);
                if(deltaL < deltaR) {
                    // 왼손이 더 가까운 경우
                    answer += "L";
                    currentL[0] = nextR;
                    currentL[1] = nextC;
                } else if(deltaL > deltaR) {
                    // 오른손이 더 가까운 경우
                    answer += "R";
                    currentR[0] = nextR;
                    currentR[1] = nextC;
                } else {
                    // 거리가 같은 경우 -> 주손으로
                    if(hand.equals("right")) {
                        answer += "R";
                        currentR[0] = nextR;
                        currentR[1] = nextC;
                    } else {
                        answer += "L";
                        currentL[0] = nextR;
                        currentL[1] = nextC;
                    }
                }
            }
        }
        return answer;
    }
}
