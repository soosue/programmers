package programmers.level2.visited_length;

import java.util.*;

public class Solution {
    /*
        풀이
        방문했던 곳에 대한 정보를 기억하고 있어야 한다.
        방문했던 곳의 정보는 점과 점으로 기록할 수 있다.
        점과 점을 hash map으로 저장해본다.
        몇번 방문했는지는 상관이 없이 한 번의 이력이 필요하므로 hash set으로 해본다.

        고려사항
        1. 지도의 크기는 5x5이다. 그 범위로 나가려하면 움직여지지 않는다.
        2. from 0,0 to 0,1과 from 0,1 to 0,0은 서로 같다.
        3. 시작은 0,0부터

        중간 지점의 좌표를 저장해보자.
     */
    private final int LIMIT = 5;
    private Map<Character, int[]> map;

    public Solution() {
        map = new HashMap<>();
        map.put('U', new int[] {0, 2});
        map.put('D', new int[] {0, -2});
        map.put('R', new int[] {2, 0});
        map.put('L', new int[] {-2, 0});
    }
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        StringBuffer sb = new StringBuffer();

        int[] pos = new int[2];
        int[] before = new int[2];
        int cnt = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            if (!canGo(pos, dir)) continue;

            sb.setLength(0);
            before[0] = pos[0];
            before[1] = pos[1];

//            if (dir == 'U') {
//                pos[1]+=2;
//            }else if (dir == 'D') {
//                pos[1]-=2;
//            }else if (dir == 'R') {
//                pos[0]+=2;
//            }else if (dir == 'L') {
//                pos[0]-=2;
//            }//map을 이용하면 다음 4줄로 바꿀 수 있다.
            before[0] = pos[0];
            before[1] = pos[1];

            pos[0] += map.get(dir)[0];
            pos[1] += map.get(dir)[1];

            sb.append((pos[0] + before[0]) / 2).append(',').append((pos[1] + before[1]) / 2);

            if (visited.contains(sb.toString())) {
                continue;
            }else {
                visited.add(sb.toString());
                cnt++;
            }
        }
        return cnt;
    }

    private boolean canGo(int[] pos, char dir) {
        if (dir == 'U') {
            return pos[1] < LIMIT * 2;
        }else if (dir == 'D') {
            return -LIMIT * 2 < pos[1];
        }else if (dir == 'R') {
            return pos[0] < LIMIT * 2;
        }else if (dir == 'L') {
            return -LIMIT * 2 < pos[0];
        }
        throw new RuntimeException("wrong dir");
    }
}
