package bronze;

import java.io.*;
import  java.util.*;
public class Solution9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        
        String answer = "F";
        if (90 <= A && A <= 100) {
            answer = "A";
        } else if  (80 <= A && A <= 89){
            answer = "B";
        } else if (70 <= A && A <= 79) {
            answer = "C";
        } else if (60 <= A && A <= 69) {
            answer = "D";
        }
        System.out.println(answer);
    }
}
