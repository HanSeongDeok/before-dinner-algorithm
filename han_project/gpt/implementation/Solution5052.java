package implementation;

import java.io.*;
import java.util.*;

public class Solution5052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            int n = Integer.parseInt(br.readLine());
            
            List<String> numbers = new ArrayList<>(); 
            for (int j = 0; j < n; j++) numbers.add(br.readLine());
            
            Collections.sort(numbers, Comparator.naturalOrder());
            boolean valid=true;
            for (int k=0; k < n-1; k++) {
                if (numbers.get(k+1).startsWith(numbers.get(k))) {
                    valid = false;
                    break;
                }
            } 
            if (valid) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");  
        }
        System.out.println(sb);
    }
}
