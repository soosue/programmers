package baekjoon.dfs_bfs.apt_complex_number_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
    /*
        풀이
        단순 탐색문제
        전체를 순회하면서 1로 시작하는 것을 0, 1이 아닌 다른 숫자로 바꾸고, 단지의 집수를 cnt하여 저장.
        바꿀때는 dfs - stack을 이용

        단지의 수는 알 수 없고 크기가 변할 수 있기만 하면 되므로, list를 이용.
        단지의 집수 정렬은 Collections.sort 이용.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        //아파트 정보 init
        int[][] apt = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < apt[i].length; j++)
                apt[i][j] = Integer.parseInt(row[j]);
        }

        List<Integer> houseCntList = new ArrayList<>();
        Stack<XY> stack = new Stack<XY>();
        int comp = 1;
        int houseCnt = 0;
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (apt[i][j] == 1) {
                    comp++;
                    houseCnt = 1;

                    XY start = XY.from(i, j);
                    stack.push(start);
                    // dfs
                    while (!stack.isEmpty()) {
                        int currentX = stack.peek().x;
                        int currentY = stack.peek().y;

                        apt[currentX][currentY] = comp;
                        houseCnt++;

                        if (0 < currentX && apt[currentX - 1][currentY] == 1) {
                            stack.push(XY.from(currentX - 1, currentY));
                        }else if (currentX < n - 1 && apt[currentX + 1][currentY] == 1) {
                            stack.push(XY.from(currentX + 1, currentY));
                        }else if (0 < currentY && apt[currentX][currentY - 1] == 1) {
                            stack.push(XY.from(currentX, currentY - 1));
                        }else if (currentY < n - 1 && apt[currentX][currentY + 1] == 1) {
                            stack.push(XY.from(currentX, currentY + 1));
                        }else {
                            stack.pop();
                            houseCnt--;
                        }
                    }
                    houseCntList.add(houseCnt);
                }
            }
        }
        Collections.sort(houseCntList);
        sb.append(comp - 1).append('\n');
        for (int i = 0; i < houseCntList.size(); i++) {
            sb.append(houseCntList.get(i)).append('\n');
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
