package silver;

import java.io.*;
import java.util.*;

/**
 * BAEKJOKN
 * 1927. 최소 힙
 * 
 */
public class Solution1927 {
    
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            if (value == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");    
            } else {
                pq.add(value);
            }
        }
        // System.out.println("---------------------");
        System.out.println(sb.toString());
    }
}
