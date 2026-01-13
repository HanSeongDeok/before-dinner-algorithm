package string;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 10799. 쇠 막대기
 * 
 * 핵심 아이디어 -> () 일 때 덱에 저장된 '(' 의 수 만큼 막대기가 생성된다. 
 */
public class Solution10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();
        Deque<Character> dq = new ArrayDeque<>();

        char prevW = 0;
        int answer = 0;
        for (char w : word.toCharArray()) {
            if (w == '(') {
                dq.add(w);
            } else {
                dq.pollLast();
                answer = prevW == '(' ? answer + dq.size() : answer + 1; 
            }
            prevW = w;
        }
        System.out.println(answer);
    }
}
