package programmers.level1.reverse_ternary;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    private final Solution sol = new Solution();

    @Test
    public void ex1() {
        int answer = sol.solution(45);
        assertThat(answer).isEqualTo(7);
    }
    @Test
    public void ex2() {
        int answer = sol.solution(125);
        assertThat(answer).isEqualTo(229);
    }
}
