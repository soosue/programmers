package programmers.level2.rotate_brace;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void ex1() {
        assertThat(new Solution().solution("[](){}")).isEqualTo(3);
    }
    @Test
    void ex2() {
        assertThat(new Solution().solution("}]()[{")).isEqualTo(2);
    }
    @Test
    void ex3() {
        assertThat(new Solution().solution("[)(]")).isEqualTo(0);
    }
    @Test
    void ex4() {
        assertThat(new Solution().solution("}}}"	)).isEqualTo(0);
    }
}