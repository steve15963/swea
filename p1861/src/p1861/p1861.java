package p1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1861 {
	//상하좌우에 있는 다른 방으로 이동할 수 있다.
	static int dx[] = {  0 , 0, -1, 1};
	static int dy[] = { -1 , 1,  0, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
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
			//처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int t = search(i,j,room,N,1);
					if( maxMove <= t ) {
						//방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것
						if(maxMove == t && room[markY][markX] <= room[i][j]) continue;
						maxMove = t;
						markX = j;
						markY = i;
					}
				}
			}
			//각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력
			//한 칸을 띄운 후, 처음에 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지를 공백으로 구분하여 출력
			System.out.println("#" + TC + " "+ room[markY][markX] + " " + maxMove);
			
		}

	}

	private static int search(int y,int x,int room[][],int N,int cnt) {
		for(int i = 0; i < 4;i++) {
			int checkY = y + dy[i];
			int checkX = x + dx[i];
			if(0 > checkX || checkX >= N || 0 > checkY || checkY >= N)
				continue;
			//방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.
			if(room[checkY][checkX] == room[y][x] +1)
				cnt = Math.max(cnt,search(checkY, checkX, room, N, cnt + 1));
		}
		return cnt;
	}

}
