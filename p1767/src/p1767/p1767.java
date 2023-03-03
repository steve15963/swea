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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			ArrayList<Point> queue = new ArrayList<>();
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && i != 0 && j != 0)
						queue.add(new Point(j,i));
				}
			}
			boolean selected[] = new boolean[queue.size()];
			subSet(0,map,N,queue,selected);
		}
	}
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = { 0, 0,-1, 1};
	private static void subSet(int cnt, int[][] map,int N,ArrayList<Point> queue,boolean selected[]) {
		if(cnt == queue.size()) {
			
			int copyMap[][] = new int[N][N];
			for(int i = 0 ; i < N; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, N);
			}
			
			ArrayList<Point> selectList = new ArrayList<>();
			for(int i = 0 ; i < queue.size(); i++) {
				if(selected[i])
					selectList.add(queue.get(i));
			}
			draw(map,)
			return;
		}
		selected[cnt] = true;
		subSet(cnt+1, map, N, queue, selected);
		selected[cnt] = false;
		subSet(cnt+1, map, N, queue, selected);
		
	}
	private static boolean isCan(int nextY, int nextX, int N) {
		// TODO Auto-generated method stub
		return 0 <= nextY && nextY < N && 0 <= nextX && nextX <= N;
	}
}
