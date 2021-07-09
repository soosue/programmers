package programmers.level2.cache;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void ex1() {
        assertThat(new Solution()
                .solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}))
                .isEqualTo(50);
    }
    @Test
    void ex2() {
        assertThat(new Solution()
                .solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}))
                .isEqualTo(21);
    }
    @Test
    void ex3() {
        assertThat(new Solution()
                .solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}))
                .isEqualTo(60);
    }
    @Test
    void ex4() {
        assertThat(new Solution()
                .solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}))
                .isEqualTo(52);
    }
    @Test
    void ex5() {
        assertThat(new Solution()
                .solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}))
                .isEqualTo(16);
    }
    @Test
    void ex6() {
        assertThat(new Solution()
                .solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}))
                .isEqualTo(25);
    }



    @Test
    void linkedHashMapTest() {
        LinkedHashMap<String, String> m = new LinkedHashMap<>(2, 0.75f, true);
        m.put("1", "1");
        m.put("2", "2");
        m.put("3", "3");
        m.put("4", "4");

        System.out.println(m.get("1"));
    }


    @Test
    void queueSizeTest() {
        Queue<String> q = new PriorityQueue<>(3);
        q.add("a");
        q.add("a");
        q.add("a");
        q.add("a");//resize됨
    }

}