package programmers.level2.triangular_snail;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution sol = new Solution();
    @Test
    void ex1() {
        int[] ans = sol.solution(4);
        Assertions.assertThat(ans).containsExactly(1, 2, 9, 3, 10, 8, 4, 5, 6, 7);
    }
    @Test
    void ex2() {
        int[] ans = sol.solution(5);
        Assertions.assertThat(ans).containsExactly(1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9);
    }
    @Test
    void ex3() {
        int[] ans = sol.solution(6);
        Assertions.assertThat(ans).containsExactly(1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11);
    }
    @Test
    void ex4() {
        int[] ans = sol.solution(1);
        Assertions.assertThat(ans).containsExactly(1);
    }
    @Test
    void ex5() {
        int[] ans = sol.solution(2);
        Assertions.assertThat(ans).containsExactly(1, 2, 3);
    }
    @Test
    void ex6() {
        int[] ans = sol.solution(3);
        Assertions.assertThat(ans).containsExactly(1, 2, 6, 3, 4, 5);
    }
}