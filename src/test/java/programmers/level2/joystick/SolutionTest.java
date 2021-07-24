package programmers.level2.joystick;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    @Test
    void ex1() {
        assertThat(new Solution().solution("JAZ")).isEqualTo(11);
    }
    @Test
    void ex2() {
        assertThat(new Solution().solution("JEROEN")).isEqualTo(56);
    }
    @Test
    void ex3() {
        assertThat(new Solution().solution("JAN")).isEqualTo(23);
    }
}