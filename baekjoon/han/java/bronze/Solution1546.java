package bronze;

import  java.io.*;
import  java.util.*;

public class Solution1546 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int box[] = new int[N];

        st = new StringTokenizer(br.readLine());
        int maxValue = 0;
        for (int i =0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken()); 
            maxValue = Math.max(maxValue, box[i]);
        }

        double answer = 0; 
        for (int n : box) {
            answer +=  (n * 100.0) / maxValue;
        }
        answer /= N;
        System.out.println(answer); 
    }
}
