package dfs_bfs;

import java.util.*;

/**
 * PROGRAMMERS
 * 78. 양과 늑대 문제
 */
public class Solution78 {
    static int[] infoBox;
    static Map<Integer, List<Integer>> treeMap = new HashMap<>();
    static int answer = 0;

    public int solution(int[] info, int[][] edges) {
        infoBox = info;
       
        for (int[] edge : edges) {
            int parent = edge[0], node = edge[1];
            treeMap.computeIfAbsent(parent, k -> new ArrayList<>()).add(node);
        }

        List<Integer> nodes = new ArrayList<>();
        nodes.add(0);
        
        dfs(0, 0, 0, nodes);
        // System.out.println(answer);
        return answer;
    }

    static private void dfs(int idx, int sheepCount, int wolfCount, List<Integer> nodes) {
        sheepCount = infoBox[idx] == 0 ? sheepCount + 1 : sheepCount;
        wolfCount = infoBox[idx] == 1 ? wolfCount + 1 : wolfCount;

        if (sheepCount <= wolfCount) return;
        answer = Math.max(sheepCount, answer);

        List<Integer> copyNode = new ArrayList<>(nodes);
        copyNode.remove(nodes.indexOf(idx));
        
        if (treeMap.containsKey(idx)) {
            List<Integer> node = treeMap.get(idx);
            copyNode.addAll(node);
        }

        for (int i : copyNode) {
            dfs(i, sheepCount, wolfCount, copyNode);
        }
    }

    public static void main(String[] args) {
        Solution78 s78 = new Solution78();
        int result = s78.solution(
            new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, 
            new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}});
    }
}