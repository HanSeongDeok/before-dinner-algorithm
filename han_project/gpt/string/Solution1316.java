package string;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1316. 그룹 단어 체커
 * 
 * 풀이 1 -> 정석 풀이
 * 풀이 2 -> regex 활용
 */
public class Solution1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            char preW = ' ';
            boolean isValid = true;
            boolean visited[] = new boolean[26];

            for (char w: word.toCharArray()) {
                int index = w - 'a';
                if (preW == w) continue;
                if (visited[index]) {
                    isValid = false;
                    break;
                } 
                preW = w;
                visited[index] = true;
            }
            if (isValid) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
