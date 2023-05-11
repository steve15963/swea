package p2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2105 {
	static int answer = -1;
	static int N = 0;
	static int map[][];
	//하우, 하좌, 상좌, 상우
	static int dy[] = { 1, 1,-1,-1};
	static int dx[] = { 1,-1,-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		//테케 만큼
		for(int TC = 1; TC <= T; TC++) {
			answer = -1;
			N = Integer.parseInt(br.readLine());
			map= new int[N][N];
			//맵 입력
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//시작지점 선택
			//i가 아래 붙으면 돌아 올 공간이 없으므로 -2 한다.
			for(int i = 0 ; i < N - 2; i++) {
				//왼쪽에 붙어 있으면 사각형을 만들 수 없다
				//그러므로 j = 2부터 시작한다.
				for(int j = 2 ; j < N; j++) {
					//디저트 체크용
					boolean eatCheck[] = new boolean[101];
					//시작 지점은 먹었음
					eatCheck[map[i][j]] = true;
					//DFS출발!!
					dessertTour(i, j, i, j, 0,eatCheck,0);
					//먹은 디저트 초기화
					Arrays.fill(eatCheck, false);
				}
			}
			System.out.println("#" + TC + " " + (answer+1));
		}

	}
	public static void dessertTour(int y,int x, int pastY,int pastX,int pastDirection,boolean eatCheck[],int eatCount) {
		for(int direction = pastDirection; direction < 4; direction++) {
			int nextY = y + dy[direction];
			int nextX = x + dx[direction];
			//갈 수 있는 공간인가?
			if(isCan(N, nextY, nextX))
				//갈 수 없다면 다음 방향
				continue;
			//이전 카페로 돌아가는 가면
			if(nextY == pastY && nextX == pastX)
				//이동하지 못한 경우이므로
				continue;
			//이동도 가능하고 돌아가지 않았지만 먹은 디저트 인가?
			if(
					eatCheck[
					         map[nextY][nextX]
					]
			) {
				//먹은 디저트라면 돌아가..
				continue;
			}
			//만약 
            if(xx == startX && yy == startY) {
                // 디저트를 먹은 최대 개수 갱신
                res = Math.max(res, cnt + 1);
                return;
            }
			//위 경우에 모두 해당하지 않는다면.
			//먹을 수 있는 디저트 이므로 진행
			eatCheck[map[nextY][nextX]] = true;
			
			//다음 디저트를 위한 여행
			dessertTour(nextY, nextX, pastY, pastX, pastDirection, eatCheck,eatCount+1);
			
		}
	}
	private static boolean isCan(int n, int nextY, int nextX) {
		return 0 <= nextY && nextY < n && 0 <= nextX && nextX < n;
	}

}
