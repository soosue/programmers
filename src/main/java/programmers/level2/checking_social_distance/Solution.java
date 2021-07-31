package programmers.level2.checking_social_distance;

public class Solution {
    /*
        풀이
        응시자를 기준으로 다른 응시자와의 거리를 측정하기 위해선 상하좌우가 빈 테이블이어야 한다.
        상하좌우가 빈테이블인지 확인한 후 빈테이블이라면 그 빈테이블을 기준으로 거리 1안에 다른 응시자가 있는지 확인한다.
        dfs?

        거리두기가 지켜졌는지 확인만 하면 되므로, 안 지켜졌을시에 바로 break.
        depth가 제한이 2이므로 스택오버플로우가 나지 않으므로, 재귀함수호출 이용.

        isViolated를 이용하여 찾으면 멈추기.

        추가로 생각
        맨해튼거리가 3이었다면
     */
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++)
            answer[i] = 1;

        for (int i = 0; i < places.length; i++) {
            boolean[][] visited = new boolean[places[i].length][places[i][0].length()];
            loop: for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) != 'P') continue;

                    visited[j][k] = true;
                    if (dfs(places[i], visited, j, k, 0, 2)) {
                        answer[i] = 0;
                        break loop;
                    }
                    visited[j][k] = false;
                }
            }
        }
        return answer;
    }

    private boolean dfs(String[] map, boolean[][] visited, int x, int y, int depth, int limit) {
        if (depth > limit) {
            return false;
        }else if (map[x].charAt(y) == 'P' && 0 < depth) {
            return true;
        }

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        loop: for (int i = 0; i < dir.length; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];

            if (0 <= newX && newX < map.length && 0 <= newY && newY < map[0].length()
                    && map[newX].charAt(newY) != 'X' && !visited[newX][newY]) {
                visited[newX][newY] = true;
                if (dfs(map, visited, newX, newY, depth + 1, limit)) return true;
                visited[newX][newY] = false;
            }
        }
        return false;
    }
}