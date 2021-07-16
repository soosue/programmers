package programmers.level2.target_number;

public class Solution {
    private int[] pm = new int[]{1, -1};

    /*
        풀이
        numbers를 모두 사용해야하므로 numbers 끝까지 순회할 것임.
        순회하는 동안에 계산된 값을 저장할 변수 필요.
        최종 계산된 값이 target일 경우 카운트할 변수 필요.

        해당 노드에서 다음 노드로 가는 부분에서 dfs메소드에 값을 직접 더해주면 tmpResult값을 다시 원복하는 코드를 줄일 수 있다.
        dfs의 코드를 분기를 직접 적어줌으로써 dfs2와 같이 코드를 줄일 수도 있다.
     */
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }

    private int dfs(int[] numbers, int pos, int target, int tmpResult) {
        int cnt = 0;
        if (pos == numbers.length) {
            return tmpResult == target ? 1 : 0;
        } else {
            for (int j = 0; j < pm.length; j++) {
//                tmpResult += numbers[pos] * pm[j];
//                cnt += dfs(numbers, pos + 1, target, tmpResult);
//                tmpResult -= numbers[pos] * pm[j];

                cnt += dfs(numbers, pos + 1, target, tmpResult + (numbers[pos] * pm[j]));
            }
        }
        return cnt;
    }

    private int dfs2(int[] numbers, int pos, int target, int tmpResult) {
        if (pos == numbers.length) {
            return tmpResult == target ? 1 : 0;
        } else {
            return dfs2(numbers, pos + 1, target, tmpResult + numbers[pos])
                    + dfs2(numbers, pos + 1, target, tmpResult - numbers[pos]);
        }
    }
}
