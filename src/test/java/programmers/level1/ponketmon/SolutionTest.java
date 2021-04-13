package programmers.level1.ponketmon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {

    private final Solution sol = new Solution();

    @Test
    public void ex1() {
        int answer = sol.solution(new int[]{3, 1, 2, 3});
        assertThat(answer).isEqualTo(2);
    }

    @Test
    public void ex2() {
        int answer = sol.solution(new int[]{3, 3, 3, 2, 2, 4});
        assertThat(answer).isEqualTo(3);
    }

    @Test
    public void ex3() {
        int answer = sol.solution(new int[]{3, 3, 3, 2, 2, 2});
        assertThat(answer).isEqualTo(2);
    }
}
