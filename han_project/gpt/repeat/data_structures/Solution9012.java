package repeat.data_structures;

import java.util.*;
import java.io.*;

public class Solution9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i< N; i++) {
            String word = br.readLine();
            Deque<Character> dq = new ArrayDeque<>();
            for (char c : word.toCharArray()) {
                if (c == '(') {
                    dq.add(c);
                } else {
                    if (dq.isEmpty()) {
                        dq.add(c);
                        break;
                    } 
                    dq.pollLast();
                }
            }
            if (dq.size() > 0) sb.append("NO").append("\n");
            else sb.append("YES").append("\n"); 
        }
        System.out.println(sb.toString());
    }
}
