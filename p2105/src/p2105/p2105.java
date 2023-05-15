package p2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2105 {
	static int answer = -1;
	static int N = 0;
	static int map[][];
	// 하우, 하좌, 상좌, 상우
	static int dy[] = { 1, 1, -1, -1 };
	static int dx[] = { 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		// 테케 만큼
		for (int TC = 1; TC <= T; TC++) {
			answer = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			// 디저트 체크용
			boolean eatCheck[] = new boolean[101];
			// 맵 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 시작지점 선택
			//  N - 2아래 노드가 최소 2개가 있으므로.
			for (int startY = 0; startY < N - 2; startY++) {
				// startX = 1는 왼쪽에 붙어 있으면 왼쪽 노드가 없으므로
				// N - 1 오른쪽에 붙어 있으면 오른쪽 노드가 없으므로.
				for (int startX = 1; startX < N - 1; startX++) {
					// 시작 지점은 먹었음
					eatCheck[map[startY][startX]] = true;
					// DFS출발!!
					dessertTour(startY, startX, startY, startX, 0, 0, eatCheck);
					// 먹은 디저트 초기화
					Arrays.fill(eatCheck, false);
				}
			}
			System.out.println("#" + TC + " " + answer);
		}

	}

	public static void dessertTour(
			int startY, 
			int startX, 
			int y, 
			int x, 
			int pastDirection,
			int eatCount,
			boolean eatCheck[]
	) {
		for (int direction = pastDirection,maxDriection = pastDirection + 2; direction < maxDriection; direction++) {
			if(direction >= 4) break;
			int nextY = y + dy[direction];
			int nextX = x + dx[direction];
			//사각형을 그려서 원점으로 돌아왔는가?
			if (nextY == startY && nextX == startX && eatCount >= 3) {
				// 디저트를 먹은 최대 개수 갱신
				// +1 하는 이유는 시작지점 카운트를 하지 않았기 때문에.
				answer = Math.max(answer, eatCount + 1);
				//이번 시작지점에서 최대수를 찾았으므로 끝
				return;
			}
			// 이동이 불 가능하거나 먹은 디저트 인가?
			if( 0 > nextY || nextY >= N || 0 > nextX || nextX >= N || eatCheck[map[nextY][nextX]]) {
				// 먹은 디저트라면 돌아가..
				continue;
			}
			// 위 경우에 모두 해당하지 않는다면.
			// 먹을 수 있는 디저트 이므로 진행
			eatCheck[map[nextY][nextX]] = true;
			// 다음 디저트를 위한 여행
 			dessertTour(startY, startX, nextY, nextX, direction, eatCount + 1, eatCheck);
			// 돌아가는 경우 이므로 디저트 먹은 체크 해제
			eatCheck[map[nextY][nextX]] = false;
		}
	}
}
