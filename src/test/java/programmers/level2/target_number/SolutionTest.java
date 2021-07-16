package programmers.level2.target_number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void ex1() {
        Assertions.assertThat(new Solution()
                .solution(new int[]{1, 1, 1, 1, 1}, 3))
                .isEqualTo(5);
    }

}