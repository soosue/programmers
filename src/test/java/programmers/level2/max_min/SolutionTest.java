package programmers.level2.max_min;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution sol = new Solution();

    @Test
    void ex1() {
        String ans = sol.solution("1 2 3 4");
        assertThat(ans).isEqualTo("1 4");
    }
    @Test
    void ex2() {
        String ans = sol.solution("-1 -2 -3 -4");
        assertThat(ans).isEqualTo("-4 -1");
    }
    @Test
    void ex3() {
        String ans = sol.solution("-1 -1");
        assertThat(ans).isEqualTo("-1 -1");
    }
}