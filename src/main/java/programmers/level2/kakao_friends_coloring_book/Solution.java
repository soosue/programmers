package programmers.level2.kakao_friends_coloring_book;

import java.util.Stack;

public class Solution {
    /*
        풀이
        전체 그림을 2차배열로 입력을 받은 상태에서
        dfs로 색칠된 영역을 찾으면 영역 개수를 카운팅 해주고 순회하면서 순회한 부분은 0으로 바꿔준다. 그와 동시에 영역의 넓이를 카운팅한다.

        이 과정을 그림 전체에 대해서 진행한다.
     */
    public int[] solution(int m, int n, int[][] picture) {
        int area = 0;
        int size = 0;
        int maxSize = 0;

        int[][] p = new int[m][n];
        Stack<XY> st = new Stack<>();

        //그림 초기화
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = picture[i][j];

        //순회 & dfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] == 0) continue;

                size = 0;
                area++;

                int color = p[i][j];
                st.push(XY.from(i, j));

                while (!st.isEmpty()) {
                    int x = st.peek().x;
                    int y = st.peek().y;

                    if (p[x][y] == color) {
                        p[x][y] = 0;
                        size++;
                    }

                    if (0 < x && p[x - 1][y] == color) {
                        st.push(XY.from(x - 1, y));
                    }else if (x < m - 1 && p[x + 1][y] == color) {
                        st.push(XY.from(x + 1, y));
                    }else if (0 < y && p[x][y - 1] == color) {
                        st.push(XY.from(x, y - 1));
                    }else if (y < n - 1 && p[x][y + 1] == color) {
                        st.push(XY.from(x, y + 1));
                    }else {
                        st.pop();
                    }
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        return new int[]{area, maxSize};
    }

    static class XY {
        private int x;
        private int y;

        private XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static XY from(int x, int y) {
            return new XY(x, y);
        }
    }
}