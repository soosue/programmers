package programmers.level1.touch_keypad;

public class Solution {

    // 0. map
    private final int[][] map = new int[][]{{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
    private StringBuilder answer = new StringBuilder();
    private String hand = "";

    // 1. 왼손 위치, 오른손 위치
    private int[] lPos = new int[]{3, 0};
    private int[] rPos = new int[]{3, 2};

    public String solution(int[] numbers, String hand) {
        this.hand = hand;


        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int[] toTouch = map[num];

            if (num == 1 || num == 4 || num == 7) {
                touchL(toTouch);
            } else if (num == 3 || num == 6 || num == 9) {
                touchR(toTouch);
            } else {
                if (isLeftClose(toTouch)) {
                    touchL(toTouch);
                } else {
                    touchR(toTouch);
                }
            }
        }

        return answer.toString();
    }

    private void touchL(int[] toTouch) {
        touch(toTouch, "L");
    }

    private void touchR(int[] toTouch) {
        touch(toTouch, "R");
    }

    private void touch(int[] toTouch, String l) {
        if ("L".equals(l)) {
            lPos = toTouch;
        }else if ("R".equals(l)) {
            rPos = toTouch;
        }
        answer.append(l);
    }

    /*
     * 왼손 : true
     * 오른손 : false
     * */
    private boolean isLeftClose(int[] to) {
        boolean b;
        if (distance(lPos, to) < distance(rPos, to)) {
            b = true;
        }else if (distance(lPos, to) > distance(rPos, to)) {
            b = false;
        }else {
            b = "left".equals(hand);
        }
        return b;
    }

    private int distance(int[] from, int[] to) {
        int x1 = from[0];
        int y1 = from[1];
        int x2 = to[0];
        int y2 = to[1];
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

}
