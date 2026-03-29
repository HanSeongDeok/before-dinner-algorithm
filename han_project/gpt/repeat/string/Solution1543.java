package repeat.string;

import java.io.*;

public class Solution1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        String target = br.readLine();

        int targetLen = target.length(); 
        int answer = 0;
        for (int i=0;  i < words.length(); i++) {
            if (i + targetLen > words.length()) break; 
            if (words.substring(i, i + targetLen).equals(target)) {
                answer++;
                i += targetLen-1; 
            }
        }
        System.out.println(answer);
    }
}
