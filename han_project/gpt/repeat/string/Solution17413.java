package repeat.string;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 17413. 단어 뒤집기 2
 */
public class Solution17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuilder sb = new StringBuilder();

        boolean flag = false;
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            if (c == '<' || c == '>') {
                flag = c == '<' ? true : false;
                while (!dq.isEmpty()) sb.append(dq.pollLast());
                sb.append(c);
                continue;
            } 
            if (flag) {
                sb.append(c);
                continue;
            }
            if (c == ' ') {
                while (!dq.isEmpty()) sb.append(dq.pollLast());
                sb.append(c);
                continue;
            }
            dq.add(c);
        }
        while (!dq.isEmpty()) sb.append(dq.pollLast());
        System.out.println(sb.toString());
    }
}
