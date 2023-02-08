package p1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1954 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int MAP[][] = new int[N][N];
			int i = 0;
			int j = 0;
			int number = 1;
			int MAPSize = N * N;
			int dy[] = {0,1,0,-1};
			int dx[] = {1,0,-1,0};
			int mode = 0;
			// N^2만큼 채운다.
			while(number <= MAPSize) {
				// 숫자를 넣고
				MAP[i][j] = number++;
				int nextI = i + dy[mode];
				int nextJ = j + dx[mode];
				//다음 주소가 유효한지?.. 유효하지 않다면 모드를 변경한다.
				if(
					nextI < 0  ||
					nextI >= N ||
					nextJ < 0  ||
					nextJ >= N
				)
					mode = ( mode + 1 ) % 4;
				//주소도 유효하고 다음 주소의 값이 0이 아니라면 모드를 변경한다.
				else if(MAP[nextI][nextJ] != 0)
					mode = ( mode + 1 ) % 4;
				i += dy[mode];
				j += dx[mode];
			}
			sb.append("#").append(tc).append("\n");
			for(int datas[]:MAP) {
				for(int data:datas) {
					sb.append(data).append(" ");
				}
				sb.append("\n");
			}
		}
		Chann
		System.out.println(sb.toString());
	}
}
