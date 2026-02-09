package data_structures;

import  java.io.*;
import  java.util.*;

/**
 * BAEKJOON
 * 13335. 트럭 
 */
public class Solution13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        Deque<Integer> boxDq = new ArrayDeque<>(); 
        Deque<Integer> bridgeDq = new ArrayDeque<>(length); 
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            boxDq.add(value);
        }

        int answer = 0;
        while (!boxDq.isEmpty()) {
            int sum = bridgeDq.stream().mapToInt(Integer::intValue).sum();
            if (length > bridgeDq.size()) {
                if (max >= sum + boxDq.peekFirst()) {
                    bridgeDq.add(boxDq.poll());
                } else {
                    bridgeDq.add(0);
                }
                answer++;
            } else {
                bridgeDq.poll();
            }
        }
        System.out.println(answer + length);
    }
}
