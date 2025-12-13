package silver;

import java.io.*;
import java.util.*;

public class Solution11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("all")) {
                List<Integer> allList = new ArrayList<>();
                for (int n=1; n<=20; n++) allList.add(n);
                dq = new ArrayDeque<>(allList);
                continue;
            } 
            if (command.equals("empty")) {
                dq = new ArrayDeque<>();
                continue;
            } 

            int value = Integer.parseInt(st.nextToken());
            if (command.equals("add")) {
                if (dq.contains(value)) continue;
                dq.add(value);
            }
            if (command.equals("remove")) {
                if (dq.contains(value)) dq.remove(value);
            } 
            if (command.equals("check")) {
                int state = dq.contains(value) ? 1 : 0;
                sb.append(state).append("\n");
                // System.out.println(state);
            } 
            if (command.equals("toggle")) {
                if (dq.contains(value)) dq.remove(value);
                else dq.add(value);
            } 
        }
        System.out.println(sb.toString());
    }
}
