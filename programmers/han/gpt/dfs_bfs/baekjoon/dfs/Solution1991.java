package dfs_bfs.baekjoon.dfs;

import java.io.*;
import java.util.*;

/**
 * 1991. 트리 순회
 */
public class Solution1991 {
    static int N;
    static Map<String, Node> treeMap = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            treeMap.put(parent, new Node(parent, right, left));
        }

        StringBuilder preSb = new StringBuilder();
        preorderDfs("A", preSb);
        System.out.println(preSb.toString());

        StringBuilder inSb = new StringBuilder();
        inorderDfs("A", inSb);
        System.out.println(inSb.toString());

        StringBuilder postSb = new StringBuilder();
        postorderDfs("A", postSb);
        System.out.println(postSb.toString());
    }

    static private void preorderDfs(String parent, StringBuilder sb) {
        if (parent.equals(".")) {
            return;
        }
        sb.append(parent);
        preorderDfs(treeMap.get(parent).left, sb);
        preorderDfs(treeMap.get(parent).right, sb);
    }

    static private void inorderDfs(String parent, StringBuilder sb) {
        if (parent.equals(".")) {
            return;
        }
        inorderDfs(treeMap.get(parent).left, sb);
        sb.append(parent);
        inorderDfs(treeMap.get(parent).right, sb);
        
    }

    static private void postorderDfs(String parent, StringBuilder sb) {
        if (parent.equals(".")) {
            return;
        }
        postorderDfs(treeMap.get(parent).left, sb);
        postorderDfs(treeMap.get(parent).right, sb);
        sb.append(parent);
    }

    static class Node {
        String left;
        String right;
        String parent;
        Node(String parent, String right, String left) {
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
