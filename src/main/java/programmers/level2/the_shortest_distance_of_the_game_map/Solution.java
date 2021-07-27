package programmers.level2.the_shortest_distance_of_the_game_map;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
        풀이
        bfs로 푼다.

        경로의 길이를 cnt하는 방법은
        1. visited[][]에 표시하면서 탐색하는 방법
        2. queue에 depth를 같이 표시하며 탐색하는 방법

        BFS에서 생각해야할 것은, queue에 넣는 순간 해당 노드는 방문한 것으로 표시하여
        다른 노드에서 해당 노드에 접근할 여지를 주지 않도록 해야한다.
     */
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<XY> q = new LinkedList<>();

        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];

        q.add(XY.of(0, 0));
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;

            if (x == n - 1 && y == m - 1) {
                return visited[x][y];
            }

            if (0 < x && maps[x - 1][y] == 1 && visited[x - 1][y] == 0) {
                q.add(XY.of(x - 1, y));
                visited[x - 1][y] += visited[x][y] + 1;
            }
            if (x < n - 1 && maps[x + 1][y] == 1 && visited[x + 1][y] == 0) {
                q.add(XY.of(x + 1, y));
                visited[x + 1][y] += visited[x][y] + 1;
            }
            if (0 < y && maps[x][y - 1] == 1 && visited[x][y - 1] == 0) {
                q.add(XY.of(x, y - 1));
                visited[x][y - 1] += visited[x][y] + 1;
            }
            if (y < m - 1 && maps[x][y + 1] == 1 && visited[x][y + 1] == 0) {
                q.add(XY.of(x, y + 1));
                visited[x][y + 1] += visited[x][y] + 1;
            }
        }
        return answer;
    }

    public int solution2(int[][] maps) {
        int answer = -1;
        Queue<XY> q = new LinkedList<>();

        int n = maps.length;
        int m = maps[0].length;

        q.add(XY.of(0, 0, 1));
        maps[0][0] = 0;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int depth = q.poll().depth;

            if (x == n - 1 && y == m - 1) {
                return depth;
            }
//            maps[x][y] = 0;

            if (0 < x && maps[x - 1][y] == 1) {
                q.add(XY.of(x - 1, y, depth + 1));
                maps[x - 1][y] = 0;
            }
            if (x < n - 1 && maps[x + 1][y] == 1) {
                q.add(XY.of(x + 1, y, depth + 1));
                maps[x + 1][y] = 0;
            }
            if (0 < y && maps[x][y - 1] == 1) {
                q.add(XY.of(x, y - 1, depth + 1));
                maps[x][y - 1] = 0;
            }
            if (y < m - 1 && maps[x][y + 1] == 1) {
                q.add(XY.of(x, y + 1, depth + 1));
                maps[x][y + 1] = 0;
            }
        }
        return answer;
    }

    static class XY {
        private int x;
        private int y;
        private int depth;

        private XY(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
        private static XY of(int x, int y) {
            return new XY(x, y, 0);
        }
        private static XY of(int x, int y, int depth) {
            return new XY(x, y, depth);
        }
    }

}
