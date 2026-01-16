package repeat.string;

import java.io.*;
import java.util.regex.Pattern;

public class Solution1316ByRegex {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i=0; i < N; i++) {
            String word  = br.readLine();
            word = Pattern.compile("(.)\\1+").matcher(word).replaceAll("$1");
            System.out.println(word);
        }
    }
}
