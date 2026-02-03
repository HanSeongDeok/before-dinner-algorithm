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
        for (int i = 0; i <= 20; i++) list.add(i);

        for (int i=0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            for (int j=start; j < (start + end) / 2; j++) {
                int s = list.get(j);
                int e = list.get(start + end-j);

                list.remove(j);
                list.add(j, e);

                list.remove(start + end-j);
                list.add(start + end-j, s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=20; i++) sb.append(list.get(i)).append(" ");
        System.out.println(sb.toString());
    }
}
