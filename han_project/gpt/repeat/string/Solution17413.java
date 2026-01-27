package repeat.string;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON 
 * 17413. 단어 뒤집기 2
 */
public class Solution17413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        
        boolean isValid = false;
        StringBuilder sb = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();

        for (char w : word.toCharArray()) {
            if (w == '<') isValid = true;
            if (isValid) {
                if (w == '>') isValid = false;
                while (!dq.isEmpty()) sb.append(dq.poll());
                sb.append(w);
                continue;
            }
            if (w == ' ') {
                while(!dq.isEmpty()) sb.append(dq.poll());
                sb.append(w);
                continue;
            }
            dq.addFirst(w);
        }
        while(!dq.isEmpty()) sb.append(dq.poll());
        System.out.println(sb.toString());
    }
}
