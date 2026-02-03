package repeat.string;

import java.io.*;

public class Solution1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String target = br.readLine();
        
        int answer = 0;
        for (int i = 0; i < word.length(); ) {
            if (word.startsWith(target, i)) {
                answer++;
                i += target.length();
            } else {
                i++;
            }
        }
        System.out.println(answer);
    }
}
