package implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1244. 스위치 켜고 끄기
 */
public class Solution1244 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int box[] = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i <= N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int studentN = Integer.parseInt(st.nextToken());
        for (int i=0; i <studentN; i++) {
            st = new StringTokenizer(br.readLine());
            int gender =  Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int n = number; n <= N; n+=number) {
                    box[n] = box[n] == 0 ? 1 : 0;
                }
            } else {
                /**
                 * @XXX 해당 방법은 매우 위험한 방식 판단 로직 + 적용 로직으로 분리해야 한다.
                 */
                // int leftN = number - 1;
                // int rightN = number + 1;
                
                // while(1 <= leftN && rightN <= N && box[leftN] == box[rightN]) {
                //     box[leftN] = box[leftN] == 0 ? 1 : 0;  
                //     box[rightN] = box[rightN] == 0 ? 1 : 0;  
                    
                //     leftN --;
                //     rightN ++;
                // }
                // box[number] = box[number] == 0 ? 1 : 0;
                
                int leftN = number, rightN = number;
                while (1 <= leftN-1 && rightN+1 <= N && box[leftN-1] == box[rightN+1]) {
                    leftN--;
                    rightN++;
                }

                for (int n=leftN; n <= rightN; n++) {
                    box[n] = 1 - box[n];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i <= N; i++) {
            sb.append(box[i]).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
