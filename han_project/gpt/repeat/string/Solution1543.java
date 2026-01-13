package repeat.string;

import java.io.*;

public class Solution1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();        
        String compareStr = br.readLine();        
        
        int answer = 0;
        for (int i=0; i <= word.length() - compareStr.length();) {
            if (word.startsWith(compareStr, i)) {
                i += compareStr.length();
                answer++;
            } else {
                i++;
            }
        }
        System.out.println(answer);
    }
}
