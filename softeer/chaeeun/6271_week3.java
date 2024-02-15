import java.io.*;
import java.util.*;

public class 6271_week3 {
    private static class Point {
        int cnt;
        int x;
        int y;

        public Point(int cnt, int x, int y) {
            this.cnt = cnt;
            this.x = x;
            this.y = y;
        }
    }

    static int R;
    static int C;
    static char[][] map;
    static int result;
    static Queue<Point> rain;
    static Queue<Point> taebom;
    static boolean[][] rainVisited;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        rainVisited = new boolean[R][C];
        rain = new LinkedList<>();
        taebom = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i] = s.toCharArray();
                if (map[i][j] == '*') {
                    rain.add(new Point(0, i, j));
                    rainVisited[i][j] = true;
                }
                if (map[i][j] == 'W') {
                    taebom.add(new Point(0, i, j));
                    visited[i][j] = true;
                }
            }
        }
        result = bfs();
        if (result == -1) {
            System.out.println("FAIL");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        while (!taebom.isEmpty()) {
            int size = rain.size();
            while (size-- > 0) {
                Point curr = rain.remove();
                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];
                    if (canGo(nx, ny) && map[nx][ny] != 'X' && map[nx][ny] != 'H' && !rainVisited[nx][ny]) {
                        rainVisited[nx][ny] = true;
                        map[nx][ny] = '*';
                        rain.add(new Point(curr.cnt, nx, ny));
                    }
                }
            }
            size = taebom.size();
            while (size-- > 0) {
                Point curr = taebom.remove();
                if (map[curr.x][curr.y] == 'H') {
                    return curr.cnt;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];
                    if (canGo(nx, ny) && map[nx][ny] != 'X' && map[nx][ny] != '*' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        taebom.add(new Point(curr.cnt + 1, nx, ny));
                    }
                }
            }
        }
        return -1;
    }
}