package bronze;

import java.io.*;

public class Solution2739 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i=1; i<10; i++) {
            sb.append(String.format("%d * %d = %d", N, i, N * i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
