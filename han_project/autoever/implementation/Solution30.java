package implementation;

// 프로그래머스 Lv.2 - 문자열 압축 (2018 KAKAO BLIND RECRUITMENT)
// https://school.programmers.co.kr/learn/courses/30/lessons/60057

import java.util.*;

public class Solution30 {
    public int solution(String s) {
        int answer = 0;
        List<String> answers = new ArrayList<>();

        for(int i=1; i<= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String prevStr = "";
            for (int j = 0; j < s.length(); j += i) {
                if (s.substring(j, Math.min(j+i, s.length())).equals(prevStr)) {
                    count++;
                } else if (count > 1){
                    sb.append(count + prevStr);
                    count = 1;
                } else {
                    sb.append(prevStr);
                }
                prevStr = s.substring(j, Math.min(j+i, s.length()));
            }
            sb.append(count > 1 ? count + prevStr : prevStr);
            answers.add(sb.toString());
        }
        Collections.sort(answers, Comparator.comparingInt(String::length));
        answer = answers.isEmpty() ? 1 : answers.get(0).length();
        return answer;
    }
    public static void main(String[] args) {
        Solution30 s30 = new Solution30();
        System.out.println(s30.solution("a"));
    }
}
