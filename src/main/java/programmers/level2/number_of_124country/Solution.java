package programmers.level2.number_of_124country;
import java.util.*;

public class Solution {
    /*
        풀이
        계산이 가능한가? vs 직접 하나씩 증가시켜줘야하는가?

        규칙을 찾아보자.
        3의 배수마다 124가 반복
        해당 숫자를 3으로 나누고 몫을 124로 표현한 값 + 나머지를 124로 표현한 값이라는 규칙이 있음
        ex)
        34인 경우
        34 / 3 = 11 ... 1
        -> 11을 124로 표현한 값 + 1을 124로 표현한 값

        여기서 11의 경우 또 다시 3으로 나누어 표현할 수 있다.

        -> 11 / 3 = 3 ... 2
        ->
        -> 3을 124로 표현한 값 + 2를 124로 표현한 값 + 1을 124로 표현한 값
        -> 4 + 2 + 1 = 421

        33인 경우
        33 / 3 = 11 ... 0
        -> 이 경우엔 10과 3으로 표현한다.
        -> 10을 124로 표현한 값 + 3을 124로 표현한 값
        -> 3을 124로 표현한 값 + 1을 124로 표현한 값 + 3을 124로 표현한 값
        -> 4 + 1 + 4 = 414

    */

    private final char[] nOf124 = new char[]{'4', '1', '2'};

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        of124_v3(n, sb);

        return sb.reverse().toString();
    }

    private void of124_v3(int n, StringBuilder sb) {
        while (n > 0) {
            sb.append(nOf124[n % 3]);
            n = (n - 1) / 3;
        }
    }

    private void of124_v2(int n, StringBuilder sb) {
        while (n > 0) {
            sb.append(nOf124[n % 3]);
            n = n % 3 == 0
                    ? n / 3 - 1
                    : n / 3;
        }
    }

    private void of124_v1(int n, StringBuilder sb) {
        while (n / 3 > 0) {
            sb.append(nOf124[n % 3]);
            n = n % 3 == 0
                    ? n / 3 - 1
                    : n / 3;
        }

        if (n % 3 != 0)
            sb.append(nOf124[n]);
    }
}