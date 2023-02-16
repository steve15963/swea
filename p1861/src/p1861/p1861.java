package p1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1861 {
	//�����¿쿡 �ִ� �ٸ� ������ �̵��� �� �ִ�.
	static int dx[] = {  0 , 0, -1, 1};
	static int dy[] = { -1 , 1,  0, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int room[][] = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxMove = 0;
			int markY = 0;
			int markX = 0;
			//ó�� � ���� ���� �濡�� �־�� ���� ���� ������ ���� �̵��� �� �ִ���
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int t = search(i,j,room,N,1);
					if( maxMove <= t ) {
						//���� ������ �ִ��� ���� �����̶�� �� �߿��� ���� ���� ���� ���� ��
						if(maxMove == t && room[markY][markX] <= room[i][j]) continue;
						maxMove = t;
						markX = j;
						markY = i;
					}
				}
			}
			//�� �׽�Ʈ ���̽����� ��#x��(x�� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ���
			//�� ĭ�� ��� ��, ó���� ����ؾ� �ϴ� �� ��ȣ�� �ִ� �� ���� ���� �̵��� �� �ִ����� �������� �����Ͽ� ���
			System.out.println("#" + TC + " "+ room[markY][markX] + " " + maxMove);
			
		}

	}

	private static int search(int y,int x,int room[][],int N,int cnt) {
		for(int i = 0; i < 4;i++) {
			int checkY = y + dy[i];
			int checkX = x + dx[i];
			if(0 > checkX || checkX >= N || 0 > checkY || checkY >= N)
				continue;
			//�濡 ���� ���ڰ� ���� �濡 ���� ���ں��� ��Ȯ�� 1 �� Ŀ�� �Ѵ�.
			if(room[checkY][checkX] == room[y][x] +1)
				cnt = Math.max(cnt,search(checkY, checkX, room, N, cnt + 1));
		}
		return cnt;
	}

}
