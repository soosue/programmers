package programmers.level1.caesar_cipher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void ex1() {
        Assertions.assertThat(new Solution().solution("AB", 1)).isEqualTo("BC");
    }
    @Test
    void ex2() {
        Assertions.assertThat(new Solution().solution("z", 1)).isEqualTo("a");
    }
    @Test
    void ex3() {
        Assertions.assertThat(new Solution().solution("a B z", 4)).isEqualTo("e F d");
    }
}