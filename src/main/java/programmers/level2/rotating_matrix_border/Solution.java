package programmers.level2.rotating_matrix_border;

public class Solution {
    /*
        풀이
        행렬을 주어진 영역만큼 회전시켜고, 회전 시킨 수 중에서 최솟값을 구해야한다.
        행렬을 회전시키는 것이 하나였다면 계산이 가능하겠지만,
        문제에서는 회전시키는 영역이 1개가 아닌 여러 개가 될 수 있고, 그에 따라 다른 회전 영역에 영향이 갈 수 있다.
        따라서, 행렬을 직접 회전시켜야 한다.
     */
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];

        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                map[i][j] = i * map[i].length + j + 1;

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            answer[i] = rotate(x1, y1, x2, y2, map);
        }
        return answer;
    }

    private int rotate(int x1, int y1, int x2, int y2, int[][] map) {
        int w = y2 - y1;
        int h = x2 - x1;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int x = x1;
        int y = y1;

        int tmp = 0;
        int prev = map[x][y];
        int min = map[x][y];

        int k = w;
        for (int i = 0; i < dx.length; i++) {
            k = i % 2 == 0 ? w : h;
            for (int j = 0; j < k; j++) {
                x += dx[i];
                y += dy[i];

                tmp = map[x][y];
                map[x][y] = prev;
                prev = tmp;

                min = Math.min(min, prev);
            }
        }
        return min;
    }
}
