package swexpert.test.maze2_1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    /*
        풀이
        dfs를 재귀호출로 푸는 방법은 stack overflow가 일어날 가능성이 있다.
        따라서 크기가 클 경우엔 stack을 이용하여 풀도록 한다.
     */
    private static final int[][] MAZE = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= 10; i++) {
            //maze 초기화
            br.readLine();
            XY start = new XY(-1 ,-1);
            for (int j = 0; j < MAZE.length; j++) {
                String[] row = br.readLine().split("");
                for (int k = 0; k < row.length; k++) {
                    MAZE[j][k] = Integer.parseInt(row[k]);
                    if (row[k].equals("2")) {
                        start.x = j;
                        start.y = k;
                    }
                }
            }

            boolean isFindPath = false;
            Stack<XY> stack = new Stack<>();
            stack.push(start);

            while (!stack.isEmpty()) {
                int currentX = stack.peek().x;
                int currentY = stack.peek().y;

                if (MAZE[currentX][currentY] == 3) {
                    isFindPath = true;
                    break;
                }

                MAZE[currentX][currentY] = 1;

                if (0 < currentX && MAZE[currentX - 1][currentY] != 1) {
                    stack.push(XY.from(currentX - 1, currentY));
                }else if (currentX < 100 && MAZE[currentX + 1][currentY] != 1) {
                    stack.push(XY.from(currentX + 1, currentY));
                }else if (0 < currentY && MAZE[currentX][currentY - 1] != 1) {
                    stack.push(XY.from(currentX, currentY - 1));
                }else if (currentY < 100 && MAZE[currentX][currentY + 1] != 1) {
                    stack.push(XY.from(currentX, currentY + 1));
                }else{
                    stack.pop();
                }
            }
            sb.append('#').append(i).append(' ').append(isFindPath ? 1 : 0).append('\n');
        }
        System.out.print(sb.toString());
    }
    static class XY {
        private int x;
        private int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static XY from(int x, int y) {
            return new XY(x, y);
        }
    }
}
