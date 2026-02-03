package repeat.implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2161. 카드 1
 */
public class Solution2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> boxDq = new ArrayDeque<>();
        Deque<Integer> answerDq = new ArrayDeque<>();
        
        for (int i=1; i<=N; i++) boxDq.add(i);
        
        while (boxDq.size() > 1) {
            answerDq.add(boxDq.poll());
            boxDq.add(boxDq.poll());
        }

        StringBuilder sb = new StringBuilder();
        while (!answerDq.isEmpty()) sb.append(answerDq.poll()).append(" ");
        sb.append(boxDq.poll());
        System.out.println(sb.toString());
    }
}
