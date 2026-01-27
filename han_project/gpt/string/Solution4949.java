package string;

import java.io.*;
import java.util.*;

public class Solution4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String word = br.readLine();
            if (word.equals(".")) break;

            Map<Character, Deque<Character>> dqMap = new HashMap<>();
            String answer = "yes";
            Deque<Character> seqDq = new ArrayDeque<>();

            for (char w : word.toCharArray()) {
                if (w == '(' || w == '[') {
                    dqMap.computeIfAbsent(w, k -> new ArrayDeque<>()).add(w);
                    seqDq.add(w);
                } 
                else if (w == ')' || w == ']') {
                    if ((w == ')' && !dqMap.containsKey('(')) || (w == ']' && !dqMap.containsKey('['))) {
                        answer = "no";
                        break;
                    } else {
                        Deque<?> dq = w == ')' ? dqMap.get('(') : dqMap.get('['); 
                        if (dq.isEmpty()){
                            answer = "no";
                            break;
                        }
                        char seq = seqDq.pollLast();
                        if ((w == ')' &&  seq != '(' ) || (w == ']' &&  seq != '[' )) {
                            answer = "no";
                            break;
                        }
                        dq.poll();
                    }
                }
            }
            
            if (answer.equals("yes") && (dqMap.containsKey('(') || dqMap.containsKey('['))) {
                int cnt = dqMap.containsKey('(') ? dqMap.get('(').size() : 0;
                cnt = dqMap.containsKey('[') ? dqMap.get('[').size() + cnt : 0 + cnt;
                answer = cnt == 0 ? "yes" : "no";
            } 
            System.out.println(answer);
        }
    }
}
