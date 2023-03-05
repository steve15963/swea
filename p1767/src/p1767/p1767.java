package p1767;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1767 {
	//최대한 많은 Core에 전원을 연결하였을 경우, 전선 길이의 합을 구하고자 한다.
	//  단, 여러 방법이 있을 경우, 전선 길이의 합이 최소가 되는 값을 구하라
	//최대한 많은 Core에 전원을 연결해도, 전원이 연결되지 않는 Core가 존재할 수 있다
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			Point processArray[] = new Point[12];
			int processCount = 0;
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1)
						processArray[processCount++] = new Point(j,i);
				}
			}
			min = Integer.MAX_VALUE;
			//boolean selected[] = new boolean[queue.size()];
			//subSet(0,map,N,queue,selected);
			for(int i = processCount; i > 0; i--) {
				boolean visit[] = new boolean[processCount];
				Point selectArray[] = new Point[i];
				combi(0,0,i,map,N,processArray,processCount,selectArray,visit);
				if(min != Integer.MAX_VALUE) break;
			}
			
			System.out.println("#" + TC + " " + min);
		}
	}






	private static void combi(int cnt,int start, int combiLength, int[][] map, int N, Point processArray[],int processCount,Point selectArray[],boolean visit[]) {
		// TODO Auto-generated method stub
		if(cnt == combiLength) {
			draw(0,0,map,selectArray,combiLength,N);
			return;
		}
		for(int i = start ; i < processCount; i++) {
			if(!visit[i]) {
				visit[i] = true;
				selectArray[cnt] = processArray[i];
				combi(cnt + 1,i,combiLength,map,N,processArray,processCount,selectArray,visit);
				visit[i] = false;
			}
		}
	}






//	private static void subSet(int cnt, int[][] map,int N,ArrayList<Point> queue,boolean selected[]) {
//		if(cnt == queue.size()) {
//	
//			ArrayList<Point> selectList = new ArrayList<>();
//			for(int i = 0 ; i < queue.size(); i++) {
//				if(selected[i]) {
//					System.out.print(queue.get(i) + " ");
//					selectList.add(queue.get(i));
//				}
//				System.out.println();
//			}
//			//draw(0,0,map,selectList,selectList.size(),N);
//			return;
//		}
//		selected[cnt] = true;
//		subSet(cnt+1, map, N, queue, selected);
//		selected[cnt] = false;
//		subSet(cnt+1, map, N, queue, selected);
//		
//	}
	static final int dy[] = {-1, 1, 0, 0};
	static final int dx[] = { 0, 0,-1, 1};
	private static void draw(int cnt,int counted,int[][] map, Point selectArray[], int size, int N) {
		if(cnt == size) {
			min = Math.min(min, counted);
			return;
		}
		Point target = selectArray[cnt];
		for(int d = 0 ; d < 4; d++) {
			int count = 0;
			int copyMap[][] = copy(map,N);
			
			//copyMap[target.y][target.x] = 2;
			
			int nextY = target.y + dy[d];
			int nextX = target.x + dx[d];
			
			boolean flag = false;
			while(isCan(nextY, nextX, N)) {
				if(copyMap[nextY][nextX] != 0) {
					flag = true;
					break;
				}
				count++;
				copyMap[nextY][nextX] = 2;
				nextY += dy[d];
				nextX += dx[d];
			}
			//print(copyMap,N);
			if(flag) continue;
			draw(cnt+1,counted+count, copyMap, selectArray, size, N);
		}
	}
	private static void print(int[][] copyMap, int n) {
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(copyMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static int[][] copy(int[][] map, int N) {
		int copyMap[][]  = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, N);
		}
		return copyMap;
	}
	private static boolean isCan(int nextY, int nextX, int N) {
		// TODO Auto-generated method stub
		return 0 <= nextY && nextY < N && 0 <= nextX && nextX < N;
	}
}
