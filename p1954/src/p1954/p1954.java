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
			// N^2留뚰겮 梨꾩슫�떎.
			while(number <= MAPSize) {
				// �닽�옄瑜� �꽔怨�
				MAP[i][j] = number++;
				int nextI = i + dy[mode];
				int nextJ = j + dx[mode];
				//�떎�쓬 二쇱냼媛� �쑀�슚�븳吏�?.. �쑀�슚�븯吏� �븡�떎硫� 紐⑤뱶瑜� 蹂�寃쏀븳�떎.
				if(
					nextI < 0  ||
					nextI >= N ||
					nextJ < 0  ||
					nextJ >= N
				)
					mode = ( mode + 1 ) % 4;
				//二쇱냼�룄 �쑀�슚�븯怨� �떎�쓬 二쇱냼�쓽 媛믪씠 0�씠 �븘�땲�씪硫� 紐⑤뱶瑜� 蹂�寃쏀븳�떎.
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
		System.out.println(sb.toString());
	}
}
