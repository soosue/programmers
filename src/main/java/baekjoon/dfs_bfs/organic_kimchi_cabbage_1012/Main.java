package baekjoon.dfs_bfs.organic_kimchi_cabbage_1012;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    /*
        배열 탐색하는 문제이다.
        배열 전체를 탐색하면서 1인 지점을 찾았을 때, 붙어있는 1들을 모두 0으로 바꾸고 cnt를 해준다.
        붙어있는 1들을 탐색하는 방법으로 bfs, dfs가 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map;
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[m][n];

            //init
            for (int j = 0; j < K; j++) {
                String[] pos = br.readLine().split(" ");
                map[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[j].length; k++) {
                    if (map[j][k] == 1) {
                        cnt++;
//                        bfs(map, j, k);
                        dfs(map, j, k);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static void bfs(int[][] map, int j, int k) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(j, k));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            if (0 < x && map[x - 1][y] == 1) {
                q.add(new Point(x - 1, y));
                map[x - 1][y] = 0;
            }
            if (x < map.length - 1 && map[x + 1][y] == 1) {
                q.add(new Point(x + 1, y));
                map[x + 1][y] = 0;
            }
            if (0 < y && map[x][y - 1] == 1) {
                q.add(new Point(x, y - 1));
                map[x][y - 1] = 0;
            }
            if (y < map[0].length - 1 && map[x][y + 1] == 1) {
                q.add(new Point(x, y + 1));
                map[x][y + 1] = 0;
            }
        }
    }

    private static void dfs(int[][] map, int j, int k) {
        Stack<Point> st = new Stack<>();
        st.push(new Point(j, k));

        while (!st.isEmpty()) {
            Point p = st.peek();
            int x = p.x;
            int y = p.y;

            if (0 < x && map[x - 1][y] == 1) {
                st.push(new Point(x - 1, y));
                map[x - 1][y] = 0;
            } else if (x < map.length - 1 && map[x + 1][y] == 1) {
                st.push(new Point(x + 1, y));
                map[x + 1][y] = 0;
            } else if (0 < y && map[x][y - 1] == 1) {
                st.push(new Point(x, y - 1));
                map[x][y - 1] = 0;
            } else if (y < map[0].length - 1 && map[x][y + 1] == 1) {
                st.push(new Point(x, y + 1));
                map[x][y + 1] = 0;
            } else {
                st.pop();
            }
        }
    }
}
