package programmers.level1.recommanding_occupation;

import java.util.*;

public class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        // 점수 저장 map, 테이블 이름 저장 배열, 점수 저장 배열
        Map<String, Integer>[] scoreMap = new HashMap[table.length];
        String[] fNames = new String[table.length];
        int[] score;

        initScoreMap(scoreMap);

        //분야별로 언어별 점수 저장
        saveScore(table, fNames, scoreMap);

        //입력 언어와 선호도에 따른 점수 계산
        score = scoringByLanAndPref(scoreMap, languages, preference);

        //최고점과 분야 선택
        int maxIdx = getIdxOfMaxScoreField(score, fNames);
        return fNames[maxIdx];
    }

    private void initScoreMap(Map<String, Integer>[] m) {
        for (int i = 0; i < m.length; i++)
            m[i] = new HashMap<>();
    }

    private void saveScore(String[] table, String[] fNames, Map<String, Integer>[] scoreMap) {
        for (int i = 0; i < table.length; i++) {
            String[] splt = table[i].split(" ");

            fNames[i] = splt[0];
            for (int j = 0; j < splt.length - 1; j++)
                scoreMap[i].put(splt[j + 1], 5 - j);
        }
    }

    private int[] scoringByLanAndPref(Map<String, Integer>[] scoreMap, String[] languages, int[] preference) {
        int[] score = new int[scoreMap.length];
        for (int i = 0; i < scoreMap.length; i++)
            for (int j = 0; j < languages.length; j++)
                score[i] += scoreMap[i].getOrDefault(languages[j], 0) * preference[j];

        return score;
    }

    private int getIdxOfMaxScoreField(int[] score, String[] fNames) {
        int maxIdx = 0;
        int max = score[maxIdx];
        for (int i = 1; i < score.length; i++) {
            if (max < score[i] || (max == score[i] && fNames[maxIdx].compareTo(fNames[i]) > 0)) {
                max = score[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}