package string;

import java.io.*;
import java.util.*;

public class Solution17413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuilder sb = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();
        boolean isTag = false; 

        for (char w : word.toCharArray()) {
            if (w == '<') isTag = true;
            if (isTag) {
                if (!dq.isEmpty()) {
                    while(!dq.isEmpty()) sb.append(dq.poll());
                }
                sb.append(w);
                if (w == '>') isTag = false;
            } else {
                if (w == ' '){
                    while(!dq.isEmpty()) sb.append(dq.poll());
                    sb.append(w);
                    continue;
                }
                dq.addFirst(w);
            }
        }

        while (!dq.isEmpty()) sb.append(dq.poll());
        System.out.println(sb.toString());
    }
}
