package string;

import java.io.*;
import java.util.*;

public class Solution17609 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            System.out.println(palindrome(word, 0, word.length()-1, ' '));
        } 
    }

    private static int palindrome(String word, int pStart, int pEnd, char prevW) {
        int answer = 0;
        while(pStart <= pEnd && answer < 2) {
            if (word.charAt(pStart) != word.charAt(pEnd)) {
                if (prevW == ' ') {
                    prevW = word.charAt(pStart);
                    answer = palindrome(word, pStart + 1, pEnd, prevW);
                    if (answer == 2) {
                        prevW = word.charAt(pEnd);
                        answer = palindrome(word, pStart, pEnd - 1, prevW);
                    }
                } else answer = 2;
                break;
            }
            pStart++;
            pEnd--;
        }
        if (prevW != ' ' && answer == 0) answer = 1;
        return answer;
    }
}
