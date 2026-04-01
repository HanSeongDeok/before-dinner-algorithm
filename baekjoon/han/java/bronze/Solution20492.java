package bronze;

import java.io.*;

public class Solution20492 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        sb.append(N - (N * 22 / 100)).append(" ").append(N - ((N * 2 / 10) * 22 / 100));
        System.out.println(sb);

    }
}
