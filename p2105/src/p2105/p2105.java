package p2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2105 {
	static int answer = -1;
	static int N = 0;
	static int map[][];
	// �Ͽ�, ����, ����, ���
	static int dy[] = { 1, 1, -1, -1 };
	static int dx[] = { 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		// ���� ��ŭ
		for (int TC = 1; TC <= T; TC++) {
			answer = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			// ����Ʈ üũ��
			boolean eatCheck[] = new boolean[101];
			// �� �Է�
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// �������� ����
			//  N - 2�Ʒ� ��尡 �ּ� 2���� �����Ƿ�.
			for (int startY = 0; startY < N - 2; startY++) {
				// startX = 1�� ���ʿ� �پ� ������ ���� ��尡 �����Ƿ�
				// N - 1 �����ʿ� �پ� ������ ������ ��尡 �����Ƿ�.
				for (int startX = 1; startX < N - 1; startX++) {
					// ���� ������ �Ծ���
					eatCheck[map[startY][startX]] = true;
					// DFS���!!
					dessertTour(startY, startX, startY, startX, startY, startX, 0, eatCheck, 0);
					// ���� ����Ʈ �ʱ�ȭ
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
			int pastY, 
			int pastX, 
			int pastDirection,
			boolean eatCheck[],
			int eatCount
	) {
		for (int direction = pastDirection; direction < 4; direction++) {
			int nextY = y + dy[direction];
			int nextX = x + dx[direction];
			// �� �� �ִ� �����ΰ�?
			if (!isCan(nextY, nextX)) {
				// �� �� ���ٸ� ���� ����
				continue;
			}
			// ���� ī��� ���ư��� ����
			if (nextY == pastY && nextX == pastX) {
				// �̵����� ���� ����̹Ƿ�
				continue;
			}
			// ���� ���������� ���ƿ� ���
			if (nextY == startY && nextX == startX) {
				// ����Ʈ�� ���� �ִ� ���� ����
				// +1 �ϴ� ������ �������� ī��Ʈ�� ���� �ʾұ� ������.
				answer = Math.max(answer, eatCount + 1);
				//�̹� ������������ �ִ���� ã�����Ƿ� ��
				return;
			}
			// �̵��� �����ϰ� ���ư��� �ʾ����� ���� ����Ʈ �ΰ�?
			if (eatCheck[map[nextY][nextX]]) {
				// ���� ����Ʈ��� ���ư�..
				continue;
			}
			// �� ��쿡 ��� �ش����� �ʴ´ٸ�.
			// ���� �� �ִ� ����Ʈ �̹Ƿ� ����
			eatCheck[map[nextY][nextX]] = true;
			// ���� ����Ʈ�� ���� ����
 			dessertTour(startY, startX, nextY, nextX, y, x, pastDirection, eatCheck, eatCount + 1);
			// ���ư��� ��� �̹Ƿ� ����Ʈ ���� üũ ����
			eatCheck[map[nextY][nextX]] = false;
		}
	}

	private static boolean isCan(int nextY, int nextX) {
		return 0 < nextY && nextY < N && 0 <= nextX && nextX < N;
	}

}
