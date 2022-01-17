package programmers.level2.remove_couple_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution sol = new Solution();
    @Test
    void ex1() {
        int ans = sol.solution("baabaa");
        Assertions.assertThat(ans).isEqualTo(1);
    }
    @Test
    void ex2() {
        int ans = sol.solution("cdcd");
        Assertions.assertThat(ans).isEqualTo(0);
    }
}