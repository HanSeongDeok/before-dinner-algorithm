package bronze;
import java.io.*;
public class Solution4999 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine().trim();
        String B = br.readLine().trim();
        
        System.out.println((A.length() >= B.length()) ? "go" : "no"); 
    }
}
