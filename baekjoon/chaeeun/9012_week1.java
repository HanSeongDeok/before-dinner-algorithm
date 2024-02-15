import java.util.*;
import java.io.*;

public class 9012_week1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            sb.append(isRight(br.readLine()) ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
    static boolean isRight(String str) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.add(1);
            else {
                if(stack.empty()) return false;
                else stack.pop();
            }
        }

        return stack.empty();
    }
}