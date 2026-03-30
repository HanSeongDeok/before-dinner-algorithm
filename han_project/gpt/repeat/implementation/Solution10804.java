package repeat.implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 10804 카드 역배치
 */
public class Solution10804 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        for (int i=1; i <= 20; i++) list.add(i);
        
        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st;
        for (int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            for (int s=start; s <= end; s++) {
                dq.add(list.get(s-1));
            }

            for(int s=start; s <= end; s++) {
                list.remove(s-1);
                list.add(s-1, dq.pollLast());
            }
        }

        list.forEach(n -> System.out.print(n + " "));
    }
}
