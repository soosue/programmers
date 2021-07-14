package programmers.level2.word_chain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /*
        풀이
        체크포인트가 있다.
        1. 이미 말한 단어를 체크해야함.
        2. 끝말잇기가 되고 있는지 체크해야함.
        3. 몇 번을 통과했는지 체크해야함.

        1의 경우 hashset을 이용하여 해결
        2의 경우 전 단어의 마지막 글자를 저장하여 해결
        3의 경우 for의 i와 n을 통하여 계산하여 해결
    */
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        int[] answer = new int[2];
        int idx = 0;
        int cnt = 0;
        boolean isEnd = false;
        char lastLetter = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (usedWords.contains(words[i]) || lastLetter != words[i].charAt(0)) {
                isEnd = true;
                idx = i % n + 1;
                cnt = i / n + 1;
                break;
            }
            usedWords.add(words[i]);
            lastLetter = words[i].charAt(words[i].length() - 1);
        }

        if (isEnd) {
            answer[0] = idx;
            answer[1] = cnt;
        }

        return answer;
    }
}
