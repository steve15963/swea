package p4014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4014 {
	static int ans = 0;
	//좌우 상하.
	static int dy[] = { 0, 0,-1, 1};
	static int dx[] = {-1, 1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TC= 1;  TC <= T ; TC ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[N][N];
			
			for(int i = 0 ; i < N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			
			//행검색
			boolean install[][] = new boolean[N][N];
			rowSearch(map,N,X,install);
			
			
			//열검색
			install = new boolean[N][N];
			colSearch(map,N,X,install);
			
			System.out.printf("#%d %d\n",TC,ans);
		}
	}
	private static void rowSearch(int[][] map, int N, int X,boolean install[][]) {
		for(int i = 0; i < N; i++) {
			//한 줄씩
			if(isCanRowRoad(map[i],N,X,install[i]))
				ans++;
		}
	}
	
	private static void colSearch(int[][] map, int N, int X,boolean install[][]) {
		for(int i = 0; i < N; i++) {
			//한 열씩
			if(isCanColRoad(map,i,N,X,install))
				ans++;
		}
	}
	
	
	private static boolean isCanColRoad(int[][] map,int index, int N, int X,boolean install[][]) {
		int count = 0;
		int origin = map[0][index];
		for(int i = 0 ; i < N; i++) {
			//원본과 탐색 대상이 같은 경우
			if(map[i][index] == origin) {
				count++;
			}
			//원본과 탐색 대상이 다른 경우
			//건설해야함.
			else {
				int t = origin - map[i][index];
				if(Math.abs(t) >= 2)
					return false;
				//탐색 대상이 더 작은 경우
				//오른쪽으로 건설해야함.
				if(t == 1) {
					int next = i;
					int startHeight = map[i][index];
					for(int j = 0 ; j < X-1; j++) {
						next += dx[1];
						//유효한 좌표이지 않으면.
						//건설 불가
						if(!isCan(next, N))
							return false;
						
						//같은 높이의 땅이 아니라면
						//건설 불가
						if(startHeight != map[next][index]) {
							return false;
						}
					}
					//내려간 값으로 변경
					origin = map[next][index];
					//건설 위치만큼 이동하며
					//중복 건설 방
					for(int j = 0; j < X; j++) {
						install[i++][index] = true;
					}
					//for증감연산자로 인해서. 
					//2번 증감되므로 하나 -
					i--;
				}
				//탐색 대상이 더 큰 경우
				//왼쪽으로 건설해야함
				else {
					//좌측으로 건설이 가능할 경우
					if(count >= X) {
						count = 1;
						origin = map[i][index];
						int ti = i - 1;
						for(int j = 0; j < X; j++) {
							if(install[ti--][index]) return false;
						}
					}
					//count가 부족하여 건설이 불가능한 경우
					//또는 건설이 불가능한 경우
					else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private static boolean isCanRowRoad(int[] map, int N, int X,boolean install[]) {
		int count = 0;
		int origin = map[0];
		for(int i = 0 ; i < N; i++) {
			//원본과 탐색 대상이 같은 경우
			if(map[i] == origin) {
				count++;
			}
			//원본과 탐색 대상이 다른 경우
			//건설해야함.
			else {
				int t = origin - map[i];
				if(Math.abs(t) >= 2)
					return false;
				//탐색 대상이 더 작은 경우
				//오른쪽으로 건설해야함.
				if(t == 1) {
					int next = i;
					int startHeight = map[i];
					for(int j = 0 ; j < X-1; j++) {
						next += dx[1];
						//유효한 좌표이지 않으면.
						//건설 불가
						if(!isCan(next, N))
							return false;
						
						//같은 높이의 땅이 아니라면
						//건설 불가
						if(startHeight != map[next]) {
							return false;
						}
					}
					//내려간 값으로 변경
					origin = map[next];
					//건설 위치만큼 이동하며
					//중복 건설 방
					for(int j = 0; j < X; j++) {
						install[i++] = true;
					}
					//for증감연산자로 인해서. 
					//2번 증감되므로 하나 -
					i--;
				}
				//탐색 대상이 더 큰 경우
				//왼쪽으로 건설해야함
				else {
					//좌측으로 건설이 가능할 경우
					if(count >= X) {
						count = 1;
						origin = map[i];
						int ti = i - 1;
						for(int j = 0; j < X; j++) {
							if(install[ti--]) return false;
						}
					}
					//count가 부족하여 건설이 불가능한 경우
					//또는 건설이 불가능한 경우
					else {
						return false;
					}
				}
			}
		}
		return true;
	}


	private static boolean isCan(int next, int n) {
		return 0 <= next && next < n;
	}

}
