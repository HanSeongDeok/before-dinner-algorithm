package implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 14719. 빗물
 */
public class Solution14719 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int box[] = new int[W];
        box[0] = Integer.parseInt(st.nextToken());

        int leftBox[] = new int[W];
        leftBox[0] = box[0];
        
        for (int i = 1; i < W; i++) {
            int value = Integer.parseInt(st.nextToken());
            leftBox[i] = Math.max(value, leftBox[i-1]);
            box[i] = value;
        }

        int rightBox[] = new int[W];
        rightBox[W-1] = box[W-1];

        for (int i = W-2; i >= 0; i--) {
            rightBox[i] = Math.max(box[i], rightBox[i+1]);
        }

        int answer = 0;
        for (int i=0; i < W; i++) {
            int value = Math.min(leftBox[i], rightBox[i]) - box[i];
            if (value > 0) answer += value;
        }
        System.out.println(answer);
    }
}
