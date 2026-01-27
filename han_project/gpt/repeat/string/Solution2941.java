package repeat.string;

import java.io.*;

public class Solution2941 {
    public static void main(String[] args) throws IOException{
        System.out.println(solution1());
        System.out.println(solution2());
    }

    private static int solution1() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();

        String[] box = {"dz=", "c-", "c=", "d-", "lj", "nj", "s=", "z="};
        for (String b : box) {
            word = word.replace(b, "#");
        }
        return word.length();
    }

    private static int solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();
        int answer = 0;
        for (int i = 0 ; i < word.length(); i++) {
            String compareStr1 = (i + 3) <= word.length() ?  word.substring(i, i+3) : "";
            String compareStr2 = (i + 2) <= word.length() ? word.substring(i, i+2) : "";
            if (compareStr1.equals("dz=")) {
                i += 2;
            } else if(compareStr2.equals("lj"))  {
                i += 1;
            } else if(compareStr2.equals("nj"))  {
                i += 1;
            } else if(compareStr2.equals("s="))  {
                i += 1;
            } else if(compareStr2.equals("z="))  {
                i += 1;
            } else if(compareStr2.equals("c="))  {
                i += 1;
            } else if(compareStr2.equals("c-"))  {
                i += 1;
            } else if (compareStr2.equals("d-")) {
                i += 1;
            }
            answer ++;
        }
        return answer;
    }
}