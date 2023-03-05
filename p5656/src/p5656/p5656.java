package p5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class p5656 {
	static class Point{
		int y;
		int x;
		int range;
		public Point(int y, int x, int range) {
			super();
			this.y = y;
			this.x = x;
			this.range = range;
		}
	}
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1 ; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			min = Integer.MAX_VALUE;
			drop(0,N,map,H,W);
			System.out.println("#"+TC + " " + min);
		}
	}

	private static void print(int map[][], int H,int W) {
		for(int i = 0; i < H; i ++) {
			for(int j = 0 ; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static boolean drop(int cnt,int N,int[][] map, int h, int w) {
		int result = getRemain(map,h,w);
		if(result == 0) {
			min = 0;
			return true;
		}
		if(cnt == N) {
			//print(map, h, w);
			min = Math.min(min, result);
			return false;
		}
		//드롭 X포인트 변경.
		for(int dropXPoint = 0; dropXPoint < w; dropXPoint++) {
			
			//findYPoint를 찾기
			int dropYPoint = 0;
			while(dropYPoint < h && map[dropYPoint][dropXPoint] == 0)
				dropYPoint++;
			
			//해당 행에 블럭이 없는경우 탐색의 이유가 없음.
			if(dropYPoint == h) continue;
			
			//맵 복사
			int copyMap[][] = new int[h][w];
			for(int i = 0 ; i < h; i++) {
				for(int j = 0 ; j < w; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
			// 드랍된 곳을 터트리고
			boom(h,w,copyMap, dropYPoint, dropXPoint);
			
			print(copyMap, h, w);
			//중력으로 당김.
			gravity(h,w,copyMap);
			
			print(copyMap, h, w);
			// N개만큼 던진다.
			if(drop(cnt+1, N, copyMap,h,w)) return true;
		}
		return false;
	}

	private static int getRemain(int[][] map, int H, int W) {
		int count = 0;
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				if(map[i][j]>0) count++;
			}
		}
		return count;

	}

	private static void gravity(int h, int w, int[][] map) {

		for(int j = 0 ; j < w; j++) {
			Stack<Integer> st = new Stack<>();
			for(int i = 0 ; i < h; i ++) {
				if(map[i][j] > 0) st.add(map[i][j]);
			}
			
			for(int i = h - 1 ; i >= 0; i--) {
				if(st.isEmpty()) map[i][j] =0;
				else map[i][j] = st.pop();
			}
		}
		
	}

	private static void boom(int h, int w, int[][] map, int startY, int startX) {
		ArrayDeque<Point> queue = new ArrayDeque<>();
		if(map[startY][startX] > 1) 
			queue.add(new Point(startY,startX, map[startY][startX]));
		map[startY][startX] = 0;
		int dy[] = {-1, 1, 0, 0};
		int dx[] = { 0, 0,-1, 1};
		
		while(!queue.isEmpty()) {
			Point target = queue.poll();
			int range = target.range;
			for(int d = 0 ; d < 4; d++) {
				int nextY = target.y;
				int nextX = target.x;
				for(int length = 1 ; length < range; length++) {
 					nextY += dy[d];
					nextX += dx[d];
					//if(!isCan(h,w,nextY,nextX)) break;
					if(!isCan(h, w, nextY, nextX)) continue;
					if(map[nextY][nextX] != 0)
						queue.add(new Point(nextY, nextX, map[nextY][nextX]));
					map[nextY][nextX] = 0;
				}
			}
		}
	}

	private static boolean isCan(int h, int w, int nextY, int nextX) {
		return 0 <= nextY && nextY < h && 0<= nextX && nextX < w;
	}
}
