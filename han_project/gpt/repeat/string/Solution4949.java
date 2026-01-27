package repeat.string;
import java.io.*;
import java.util.*;

public class Solution4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String word = br.readLine();
            if (word.equals(".")) break;

            String answer = "yes";
            Deque<Character> seqDq = new ArrayDeque<>();
            
            for (char w : word.toCharArray()) {
                if (w == '(' || w == '[') seqDq.add(w);
                else if (w == ')' || w == ']') {
                    if (seqDq.isEmpty()) {
                        answer = "no";
                        break;
                    }
                    char compareW = seqDq.pollLast();
                    boolean isMatch = true;
                    if (w == ')' ) {
                        if (compareW != '(') isMatch = false;
                    } else if (w == ']' ) {
                        if (compareW != '[') isMatch = false;
                    }
                    if (isMatch) continue;
                    answer = "no";
                    break;
                }
            }
            answer = answer.equals("yes") && seqDq.isEmpty() ? "yes" : "no";
            System.out.println(answer);
        }
    }
}
