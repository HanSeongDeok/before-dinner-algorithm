package bronze;

import java.io.*;
import  java.util.*;
public class Solution9086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            sb.append(s.charAt(0)).append(s.charAt(s.length()-1));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
