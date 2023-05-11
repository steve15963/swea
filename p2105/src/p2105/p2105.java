package p2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2105 {
	static int answer = -1;
	static int N = 0;
	static int map[][];
	//�Ͽ�, ����, ����, ���
	static int dy[] = { 1, 1,-1,-1};
	static int dx[] = { 1,-1,-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		//���� ��ŭ
		for(int TC = 1; TC <= T; TC++) {
			answer = -1;
			N = Integer.parseInt(br.readLine());
			map= new int[N][N];
			//�� �Է�
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//�������� ����
			//i�� �Ʒ� ������ ���� �� ������ �����Ƿ� -2 �Ѵ�.
			for(int i = 0 ; i < N - 2; i++) {
				//���ʿ� �پ� ������ �簢���� ���� �� ����
				//�׷��Ƿ� j = 2���� �����Ѵ�.
				for(int j = 2 ; j < N; j++) {
					//����Ʈ üũ��
					boolean eatCheck[] = new boolean[101];
					//���� ������ �Ծ���
					eatCheck[map[i][j]] = true;
					//DFS���!!
					dessertTour(i, j, i, j, 0,eatCheck,0);
					//���� ����Ʈ �ʱ�ȭ
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
			//�� �� �ִ� �����ΰ�?
			if(isCan(N, nextY, nextX))
				//�� �� ���ٸ� ���� ����
				continue;
			//���� ī��� ���ư��� ����
			if(nextY == pastY && nextX == pastX)
				//�̵����� ���� ����̹Ƿ�
				continue;
			//�̵��� �����ϰ� ���ư��� �ʾ����� ���� ����Ʈ �ΰ�?
			if(
					eatCheck[
					         map[nextY][nextX]
					]
			) {
				//���� ����Ʈ��� ���ư�..
				continue;
			}
			//���� 
            if(xx == startX && yy == startY) {
                // ����Ʈ�� ���� �ִ� ���� ����
                res = Math.max(res, cnt + 1);
                return;
            }
			//�� ��쿡 ��� �ش����� �ʴ´ٸ�.
			//���� �� �ִ� ����Ʈ �̹Ƿ� ����
			eatCheck[map[nextY][nextX]] = true;
			
			//���� ����Ʈ�� ���� ����
			dessertTour(nextY, nextX, pastY, pastX, pastDirection, eatCheck,eatCount+1);
			
		}
	}
	private static boolean isCan(int n, int nextY, int nextX) {
		return 0 <= nextY && nextY < n && 0 <= nextX && nextX < n;
	}

}
