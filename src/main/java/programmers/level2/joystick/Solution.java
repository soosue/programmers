package programmers.level2.joystick;

public class Solution {
    private int step = 0;
    /*
        풀이
        조건이 시작에서 끝으로는 갈 수 있지만,
        끝에서 시작으로는 올 수 없다.

        계산하는 방법 vs 직접 하기
        계산하는 방법이 딱히 떠오르지 않아서 직접하는 방법으로 풀었다.

        1. 현재 위치에서 왼쪽 오른쪽으로 한칸씩 증가시키며 바꿔야하는 위치를 찾는다.
        2. 바꿔야하는 위치로 옮기고 알파벳을 맞춰준다.
        3. 1, 2 과정을 반복한다.

        조건
        끝 부분에서 오른쪽으로 시작지점으로 넘어올 수 없는 조건이 붙어있다.

     */
    public int solution(String name) {
        int[] tName = initTmpName(name);// A = 0, B = 1, C = 2, ... Y = 24, Z = 25
        step = calMinStep(tName);
        return step;
    }

    private int calMinStep(int[] tName) {
        int idx = 0;
        int difCnt = difCnt(tName);
        while (difCnt > 0) {
            idx = findIdxTobeChanged(tName, idx);
            step += calUpDownMinStep(0, tName[idx]);
            tName[idx] = 0;
            difCnt--;
        }
        return step;
    }

    private int findIdxTobeChanged(int[] tName, int idx) {
        for (int i = 0; i <= tName.length / 2; i++) {
            if (toBeChanged(tName, idx, i)) {
                idx = findIdx(tName, idx, i);
                step += i;
                break;
            }
        }
        return idx;
    }

    private int findIdx(int[] tName, int nextIdx, int i) {
        int rightIdx = (nextIdx + i) % tName.length;
        int leftIdx = (tName.length + nextIdx - i) % tName.length;

        if (rightIdx < nextIdx) {
            if (checkOnlyLeftIdx(tName, leftIdx))
                nextIdx = leftIdx;
        }else if (nextIdx < rightIdx) {
            if (checkOnlyRightIdx(tName, rightIdx))
                nextIdx = rightIdx;
            else if (checkOnlyLeftIdx(tName, leftIdx))
                nextIdx = leftIdx;
        }else if(nextIdx == rightIdx) {
            nextIdx = rightIdx;
        }
        return nextIdx;
    }

    private boolean toBeChanged(int[] tName, int nextIdx, int i) {
        boolean toBeChanged = false;

        int rightIdx = (nextIdx + i) % tName.length;
        int leftIdx = (tName.length + nextIdx - i) % tName.length;

        if (rightIdx < nextIdx) {
            toBeChanged = checkOnlyLeftIdx(tName, leftIdx);
        }else if (nextIdx < rightIdx) {
            toBeChanged = checkBothSideIdx(tName, rightIdx, leftIdx);
        }else if (nextIdx == rightIdx) {
            toBeChanged = checkOnlyRightIdx(tName, rightIdx);
        }
        return toBeChanged;
    }

    private boolean checkBothSideIdx(int[] tName, int rightIdx, int leftIdx) {
        return tName[rightIdx] > 0 || checkOnlyLeftIdx(tName, leftIdx);
    }

    private boolean checkOnlyRightIdx(int[] tName, int rightIdx) {
        return tName[rightIdx] > 0;
    }

    private boolean checkOnlyLeftIdx(int[] tName, int leftIdx) {
        return tName[leftIdx] > 0;
    }

    private int calUpDownMinStep(int from, int to) {
        int udStep = 0;
        int calNum = 26 - from;
        from = 0;
        to = (to + calNum) % 26;

        if (to < 13)
            udStep = to - from;
        else if (13 < to)
            udStep = 26 - to;
        else if (to == 13)
            udStep = 13;

        return udStep;
    }

    private int[] initTmpName(String name) {
        //O(n)
        int[] tmpName = new int[name.length()];
        for (int i = 0; i < tmpName.length; i++)
            tmpName[i] = name.charAt(i) - 'A';
        return tmpName;
    }

    private int difCnt(int[] tName) {
        //O(n)
        int difCnt = 0;
        for (int c : tName)
            if (c != 0) difCnt++;

        return difCnt;
    }
}