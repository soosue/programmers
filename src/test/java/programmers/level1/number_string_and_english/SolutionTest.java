package programmers.level1.number_string_and_english;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void ex1() {
        Assertions.assertThat(new Solution().solution("one4seveneight")).isEqualTo(1478);
    }
    @Test
    void ex2() {
        Assertions.assertThat(new Solution().solution("23four5six7")).isEqualTo(234567);
    }
    @Test
    void ex3() {
        Assertions.assertThat(new Solution().solution("2three45sixseven")).isEqualTo(234567);
    }
    @Test
    void ex4() {
        Assertions.assertThat(new Solution().solution("123")).isEqualTo(123);
    }
}