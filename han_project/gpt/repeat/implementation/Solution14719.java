package repeat.implementation;

import java.io.*;
import java.util.*;
public class Solution14719 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int leftP = 0;
        int rightP = W-1;

        st = new StringTokenizer(br.readLine());
        int box[] = new int[W];
        for (int i=0; i < W; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int preL = 0;
        int preR = W-1;
        while (leftP < rightP) {
            if (box[preL] >= box[rightP]) {
                rightP--;
                if (box[preR] - box[rightP] >0) {
                    answer += box[preR] - box[rightP];
                } else preR = rightP;
                
            } else {
                leftP++;
                if (box[preL] - box[leftP] > 0){
                    answer += box[preL] - box[leftP];
                } else preL = leftP;
            }
        }
        System.out.println(answer);
    }
}
