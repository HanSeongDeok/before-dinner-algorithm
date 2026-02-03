package string;

import java.io.*;
import java.util.*;
/**
 * BAEKJOON
 * 9012 괄호
 */
public class Solution9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            Deque<Character> dq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            
            String word = st.nextToken();
            boolean answer = true;
            
            for (char w : word.toCharArray()) {
                if (w == '(') dq.add(w);
                else {
                    if (dq.isEmpty()) {
                        answer = false;
                        break;
                    } else dq.pollLast();
                }
            }
            if (!dq.isEmpty()) answer = false;            
            sb.append((answer) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}
