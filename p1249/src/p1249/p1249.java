package p1249;

import java.util.PriorityQueue;
import java.util.Scanner;

public class p1249 {
	static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] map;
    static boolean[][] visited;

    static PriorityQueue<int[]> pq;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        int answer = 0;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            sc.nextLine();

            map = new int[n][n];
            visited = new boolean[n][n];
            pq.clear();

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            int[] start = new int[] { 0, 0, 0 };
            pq.offer(start);
            while (!pq.isEmpty()) {
                int[] now = pq.poll();
                int x = now[0];
                int y = now[1];

                visited[x][y] = true;
                // 조건 체크
                if (x == n - 1 && y == n - 1) {
                    answer = now[2];
                    break;
                }

                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (!inRange(nx, ny, n) || visited[nx][ny]) {
                        continue;
                    }

                    pq.offer(new int[] { nx, ny, now[2] + map[nx][ny] });
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    static boolean inRange(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

