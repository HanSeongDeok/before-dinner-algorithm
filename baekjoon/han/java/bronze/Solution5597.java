package bronze;

import java.io.*;
/**
 * BAEKJOON
 * 5597. 과제 안내신 분...?
 */
public class Solution5597 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] box = new int[31];        

        for (int i=0; i<28; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            box[n] = 1; 
        }

        for (int i=1; i<31; i++) {
            if (box[i] == 0) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
}
