package p2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2105_2_self {

	// map : N * N
	//사각형 모양을 그려야함 -> 대각선 회전.
	// 지역 밖으로 나가면 안됨
	// 중복 디저트 불가
	// 방문한곳 다시 방문 불가
	
	// N 4이상 20이하
	// 디저트 수 1개 이상 100개 이하.
	// 정답은 가능한 경우 중 디저트를 가장 많이 먹을 때의 디저트 수
	
	static int answer;
	static int N;
	static boolean eat[];
	static int map[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int TC = 1; TC <= T; TC++) {
			
			//초기화 시작
			answer = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			eat = new boolean[101];
			//초기화 끝
			
			//맵 입력 시작
			for(int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//맵 입력 끝
			
			
			// 탐색 시작
			//시작 포지션 선택
			//Y축은 나보다 아래에 최소 2개의 점이 있으므로
			//시작점은 0 끝점은 N -2
			for(int i = 0; i < N - 2; i ++) {
				//x축은 시작 점이 최소 좌에 1개 우에 1개가 있으므로
				//시작 지점은 1, 끝지점은 N -1
				for(int j = 1; j < N - 1; j++) {
					//DFS로 탐색 출발
					//디저트 초기화
					//Arrays.fill(eat, false);
					
					eat[map[i][j]] = true;
					DFS(i,j,i,j,0,0);
					eat[map[i][j]] = false;
					
					//DFS 끝
				}
			}
			
			//탐색 끝
			
			//답 시작
			System.out.println("#" + TC + " " + answer);
			//답 끝
		}
	}
	/**
	 * @param y 시작 지점
	 * @param x 시작 지점
	 * @param startY 출발 지점
	 * @param startX 출발 지점
	 * @param eatCount 먹은 카운트
	 * @param pastD 과거 방향
	 */
	//이동 순서는 우하, 좌하, 좌상, 우상
	static int dy[] = { 1, 1,-1,-1};
	static int dx[] = { 1,-1,-1, 1};
	
	public static void DFS(int y,int x,int startY,int startX,int eatCount,int pastD) {
		//탐색
		for(
				int d = pastD,
				maxD = pastD+2 < 4 ? pastD + 2 : 4;
				
				d < maxD;
				d++
		){
			//다음으로 갈 곳
			int nextY = y + dy[d];
			int nextX = x + dx[d];
			//다음 좌표가 갈 수 없으면 continue
			if(!isCan(nextY,nextX)) continue;
			
			if(nextY == startY && nextX == startX && eatCount >= 3) {
				answer = Math.max(answer, eatCount+1);
				return;
			}
			
			//다음 좌표가 먹은 디저트라면 continue
			if(eat[map[nextY][nextX]]) continue;
			
			//움직 일 수 있는 좌표이고
			//먹지 않은 디저트라면 DFS 출발!
			eat[map[nextY][nextX]] = true;
			DFS(nextY,nextX,startY,startX,eatCount+1,d);
			eat[map[nextY][nextX]]  = false;
			
		}
		
		
	}

	private static boolean isCan(int nextY, int nextX) {
		// TODO Auto-generated method stub
		return 0 <= nextY && nextY < N && 0 <= nextX && nextX < N;
	}
}
