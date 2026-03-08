package string;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 1406. 에디터
 */
public class Solution1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String words = st.nextToken();
        Deque<String> leftDq = new ArrayDeque<>();
        Deque<String> rightDq = new ArrayDeque<>();

        for (char w : words.toCharArray()) {
            leftDq.add(String.valueOf(w));   
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("P")) {
                leftDq.add(st.nextToken());
            } else if (cmd.equals("D")) {
                if (!rightDq.isEmpty()) leftDq.add(rightDq.poll());
            } else if (cmd.equals("L")) {
                if (!leftDq.isEmpty()) rightDq.addFirst(leftDq.pollLast());
            } else if (cmd.equals("B")) {
                if(!leftDq.isEmpty()) leftDq.removeLast();
            } 
        }

        StringBuilder sb = new StringBuilder();
        while (!leftDq.isEmpty()) sb.append(leftDq.poll());
        while (!rightDq.isEmpty()) sb.append(rightDq.poll());
        System.out.println(sb.toString());
    }
}
