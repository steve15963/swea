package p4014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4014_2 {
	static int ans = 0;
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
			
			//행검색
			rowSearch(map,N,X);
			//열검색
			colSearch(map,N,X);
			
			System.out.println(ans);
		}
	}
	
	private static void colSearch(int[][] map, int N, int X) {
		for(int i = 0 ; i < N; i++) {
			int origin = map[0][i];
			int origin_Count = 0;
			for(int j = 0 ; j < N; j++) {
				//origin과 같은 경우
				if(origin == map[j][i]) {
					origin_Count++;
					if(origin_Count == N) ans++;
					continue;
				}
				//origin이 작은 경우
				//좌측으로 건설
				else if(origin < map[j][i]) {
					//origin_count가 x보다 크거나 같은경우
					//그냥 건설이 가능함.
					if(origin_Count >= X) {
						origin = map[j][i];
						origin_Count = 1;
					}
					//건설이 불가능하므로  더 이상의 검사가 무의미
					else {
						break;
					}
				}
				//origin이 큰 경우
				//우측으로 건설
				else if(origin > map[j][i]) {
					//오른쪽으로 건설이 가능한가?
					if(buildDown(map,N,X,i,j)) {
						origin = map[j][i];
						j = j + X + 1;
					}
					//건설의 실패의 경우
					else {
						break;
					}
				}
				//모든 경우의 수를 통과하면 ans++하여 활주로 건설함.
				ans++;
			}
		}
		
	}

	//좌우 상하.
	static int dy[] = { 0, 0,-1, 1};
	static int dx[] = {-1, 1, 0, 0};
	
	private static void rowSearch(int[][] map, int N, int X) {
		for(int i = 0 ; i < N; i++) {
			int origin = map[i][0];
			int origin_Count = 0;
			for(int j = 0 ; j < N; j++) {
				//origin과 같은 경우
				if(origin == map[i][j]) {
					origin_Count++;
					if(origin_Count == N) ans++;
					continue;
				}
				//origin이 작은 경우
				//좌측으로 건설
				else if(origin < map[i][j]) {
					//origin_count가 x보다 크거나 같은경우
					//그냥 건설이 가능함.
					if(origin_Count >= X) {
						origin = map[i][j];
						origin_Count = 1;
					}
					//건설이 불가능하므로  더 이상의 검사가 무의미
					else {
						break;
					}
				}
				//origin이 큰 경우
				//우측으로 건설
				else if(origin > map[i][j]) {
					//오른쪽으로 건설이 가능한가?
					if(buildRight(map,N,X,i,j)) {
						origin = map[i][j];
						j = j + X + 1;
					}
					//건설의 실패의 경우
					else {
						break;
					}
				}
				//모든 경우의 수를 통과하면 ans++하여 활주로 건설함.
				ans++;
			}
		}
	}


	private static boolean buildRight(int[][] map, int N, int X, int i, int j) {
		//1칸은 중간에 있어야 하므로.
		int origin = map[i][j];
		j++;
		//x의 길이만큼 경사로 건설
		for(int cnt = 0 ; cnt < X; cnt++) {
			//다음 좌표
			j += dx[1];
			//좌표가 유효하면서
			//첫값과 일치하면
			//건설 가능
			if(isCan(j, N) && origin == map[i][j]);
			//좌표가 유효하지 않다면 끝.
			//건설이 불가능함.
			else {
				return false;
			}
			
		}
		return true;
	}
	
	private static boolean buildDown(int[][] map, int N, int X, int i, int j) {
		//1칸은 중간에 있어야 하므로.
		int origin = map[j][i];
		//x의 길이만큼 경사로 건설
		for(int cnt = 0 ; cnt < X; cnt++) {
			//다음 좌표
			j += dy[3];
			//좌표가 유효하면서
			//첫값과 일치하면
			//건설 가능
			if(isCan(j, N) && origin == map[j][i]);
			//좌표가 유효하지 않다면 끝.
			//건설이 불가능함.
			else {
				return false;
			}
			
		}
		return true;
	}
	


	private static boolean isCan(int next, int n) {
		return 0 <= next && next < n;
	}

}
