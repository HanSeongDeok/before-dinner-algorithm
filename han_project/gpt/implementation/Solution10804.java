package implementation;

import java.io.*;
import java.util.*;

public class Solution10804 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i=0; i <= 20; i++) list.add(i);

        for (int i=0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            for (int s = start; s <= (int)(end + start) / 2; s++) {
                int startValue = list.get(s);
                int endValue = list.get(end + start - s);

                list.remove(s);
                list.add(s, endValue);
                
                list.remove(end + start - s);
                list.add(end + start - s, startValue);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=20; i++) sb.append(list.get(i)).append(" ");
        System.out.println(sb.toString());
    }
}
