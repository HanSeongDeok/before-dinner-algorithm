package implementation;

import java.io.*;
import java.util.*;
/**
 * BAEKJOON
 * 1874. 스택 수열
 */
public class Solution1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> targetDq = new ArrayDeque<>();
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(br.readLine());
            targetDq.addLast(value);
        }

        for (int i=1; i <= N; i++) {
            dq.addLast(i);
            sb.append("+").append("\n");
            while (!targetDq.isEmpty() && targetDq.peekFirst().equals(dq.peekLast())) {
                targetDq.pollFirst();
                dq.pollLast();
                sb.append("-").append("\n");
            }
        } 
        System.out.println(targetDq.isEmpty() ? sb.toString() : "NO");
    }
}
