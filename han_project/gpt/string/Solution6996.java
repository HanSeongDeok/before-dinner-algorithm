package string;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 6996. 애너그램
 */
public class Solution6996 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        int N = Integer.parseInt(st);
        for (int i=0; i < N; i++) {
            String[] targets = br.readLine().split(" ");

            char[] a = targets[0].toCharArray();
            char[] b = targets[1].toCharArray();
            
            Arrays.sort(a);            
            Arrays.sort(b);

            System.out.println(String.format("%s & %s are %s.", 
                targets[0], targets[1], 
                Arrays.equals(a, b) ? "anagrams" : "NOT anagrams"
            ));
        }
    }
}
