package string;

import java.io.*;

/**
 * BAEKJOON
 * 1543. 문서 검색
 */
public class Solution1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String compareStr = br.readLine();
        int answer = 0;
    
        for (int i = 0; i < word.length(); i++) {
            String box = word.substring(i);
            int cnt = 0;
            int index = 0;
            for (char w : box.toCharArray()) {
                if (compareStr.charAt(index) == w) {
                    index++;
                    if (index == compareStr.length()) {
                        cnt++;
                        index = 0;
                    }
                } else {
                    index = 0;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
