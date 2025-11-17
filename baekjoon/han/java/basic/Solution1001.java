package baekjoon.han.java.basic;

import java.io.*;
import java.util.*;
/**
 * 1001. A-B
 */
public class Solution1001 {
    public int solution(int A, int B) {
        return A - B;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Solution1001 s1001 = new Solution1001();
        
        int A = Integer.parseInt(st.nextToken()); 
        int B = Integer.parseInt(st.nextToken());

        System.out.println(s1001.solution(A, B));
    }
}
