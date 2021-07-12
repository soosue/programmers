package programmers.level2.carpet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void ex1() {
        Assertions.assertThat(new Solution()
                .solution(10, 2))
                .isEqualTo(new int[]{4, 3});
    }
    @Test
    void ex2() {
        Assertions.assertThat(new Solution()
                .solution(8, 1))
                .isEqualTo(new int[]{3, 3});
    }
    @Test
    void ex3() {
        Assertions.assertThat(new Solution()
                .solution(24, 24))
                .isEqualTo(new int[]{8, 6});
    }

}