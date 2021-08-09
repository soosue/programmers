package programmers.level3.road_to_school;

public class Solution {
    /*
        풀이
        dynamic programming 에서 단골로 나오는 문제이다.

        집에서부터 오른쪽으로 차례대로 순회하면서 해당 좌표에 도달할 수 있는 경로 수를 저장한다.
        해당 좌표 (x, y)에 도달할 수 있는 경로 수는 (x - 1, y)의 경로 수 + (x, y - 1)의 경로 수이다.

        puddle이 있으므로 puddle인 곳은 경로 수를 세는데 포함하지 않도록 한다.

        wayCnt를 더하는 과정에서 int의 범위를 넘을 수가 있으므로, 더하는 인수를 %로 나누는 것이 아닌, 결과를 %로 나누어 놓는다.



     */

    private int[][] wayCnt;
    private boolean[][] isPuddle;

    public int solution(int m, int n, int[][] puddles) {
        initVariable(m, n);

        initWayCnt();
        initPuddle(puddles);

        startWayCnt();
        return wayCnt[m][n];
    }

    private void initWayCnt() {
        wayCnt[1][1] = 1;
    }

    private void initVariable(int m, int n) {
        wayCnt = new int[m + 1][n + 1];
        isPuddle = new boolean[m + 1][n + 1];
    }

    private void startWayCnt() {
        for (int x = 1; x < wayCnt.length; x++)
            for (int y = 1; y < wayCnt[x].length; y++)
                if (!isPuddle[x][y])
                    wayCnt(x, y);
    }

    private void wayCnt(int x, int y) {
        int[][] del = new int[][]{{-1, 0}, {0, -1}};

        for (int i = 0; i < del.length; i++)
            if (!isPuddle[x + del[i][0]][y + del[i][1]])
                wayCnt[x][y] += wayCnt[x + del[i][0]][y + del[i][1]];

        wayCnt[x][y] %= 1000000007;
    }

    private void initPuddle(int[][] puddles) {
        for (int[] puddle : puddles)
            isPuddle[puddle[0]][puddle[1]] = true;
    }
}