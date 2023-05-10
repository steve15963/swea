package p2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2105 {
	//하우, 하좌, 상좌, 상우
	static int dy[] = { 1, 1,-1,-1};
	static int dx[] = { 1,-1,-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		//테케 만큼
		for(int TC = 1; TC <= T; TC++) {
			int answer = -1;
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			//맵 입력
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//시작지점 선택
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					boolean eatCheck[] = new boolean[101];
					int nextY = i;
					int nextX = j;
					int d = 0;
					int moveCount = 1;
					//시작 지점은 먹었음
					eatCheck[map[nextY][nextX]] = true;
					//사방 대각 탐색
					while(d<4) {
						nextY = nextY + dy[d];
						nextX = nextX + dx[d];
						//다음이 가능하고 먹지 않은 디저트라면 이동.
						//이동회수 카운트.
						//먹은 디저트 체크
						//및 다음(continue)
						if(isCan(N,nextY,nextX) && !eatCheck[map[nextY][nextX]]) {
							moveCount++;
							System.out.println("move Y : " + nextY);
							System.out.println("move X : " + nextX);
							System.out.println("eat : " + map[nextY][nextX] );
							eatCheck[map[nextY][nextX]] = true;
						}
						//다음이 불가능하다면.
						//도착했는가?
						//재자리로 돌아간다.(dy dx -)
						//D를 증가한다.
						//다음(continue)
						else {
							if(nextY == i && nextX == j) {
								answer = Math.max(answer, moveCount);
								System.out.println("value Change : " + answer);
								break;
							}
							nextY = nextY - dy[d];
							nextX = nextX - dx[d];
							d++;
							System.out.println("diretion Change");
						}
					}
					
				}
			}
			System.out.println("#" + TC + " " + answer);
		}

	}
	private static boolean isCan(int n, int nextY, int nextX) {
		return 0 <= nextY && nextY < n && 0 <= nextX && nextX < n;
	}

}
