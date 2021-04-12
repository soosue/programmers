package programmers.level1.recommend_new_id;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution sol = new Solution();

    @Test
    public void ex1() {
        String answer = sol.solution("...!@BaT#*..y.abcdefghijklm");
        assertThat(answer).isEqualTo("bat.y.abcdefghi");
    }
    @Test
    public void ex2() {
        String answer = sol.solution("z-+.^.");
        assertThat(answer).isEqualTo("z--");
    }
    @Test
    public void ex3() {
        String answer = sol.solution("=.=");
        assertThat(answer).isEqualTo("aaa");
    }
    @Test
    public void ex4() {
        String answer = sol.solution("123_.def");
        assertThat(answer).isEqualTo("123_.def");
    }
    @Test
    public void ex5() {
        String answer = sol.solution("abcdefghijklmn.p");
        assertThat(answer).isEqualTo("abcdefghijklmn");
    }

}