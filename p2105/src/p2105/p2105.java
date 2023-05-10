package p2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2105 {
	//�Ͽ�, ����, ����, ���
	static int dy[] = { 1, 1,-1,-1};
	static int dx[] = { 1,-1,-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		//���� ��ŭ
		for(int TC = 1; TC <= T; TC++) {
			int answer = -1;
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			//�� �Է�
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//�������� ����
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					boolean eatCheck[] = new boolean[101];
					int nextY = i;
					int nextX = j;
					int d = 0;
					int moveCount = 1;
					//���� ������ �Ծ���
					eatCheck[map[nextY][nextX]] = true;
					//��� �밢 Ž��
					while(d<4) {
						nextY = nextY + dy[d];
						nextX = nextX + dx[d];
						//������ �����ϰ� ���� ���� ����Ʈ��� �̵�.
						//�̵�ȸ�� ī��Ʈ.
						//���� ����Ʈ üũ
						//�� ����(continue)
						if(isCan(N,nextY,nextX) && !eatCheck[map[nextY][nextX]]) {
							moveCount++;
							System.out.println("move Y : " + nextY);
							System.out.println("move X : " + nextX);
							System.out.println("eat : " + map[nextY][nextX] );
							eatCheck[map[nextY][nextX]] = true;
						}
						//������ �Ұ����ϴٸ�.
						//�����ߴ°�?
						//���ڸ��� ���ư���.(dy dx -)
						//D�� �����Ѵ�.
						//����(continue)
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
