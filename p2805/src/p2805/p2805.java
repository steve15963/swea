package p2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int round = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=round;tc++) {
			int MapSize = Integer.parseInt(br.readLine());
			char Map[][] = new char[MapSize][];
			//한라인씩 리딩
			for(int i = 0 ; i<MapSize;i++) {
				Map[i] = br.readLine().toCharArray();
			}
			
			// 이번 테케 기본값 정리.
			int sum = 0;
			int mid = MapSize/2;
			
			// 상부 덧셈
			for(int i = 0; i < mid; i++) {
				for(int j = mid - i; j<=mid+i;j++) {
					sum += Map[i][j] - '0';
				}
			}
			//하부 덧셈
			for(int i = mid; i <= MapSize; i++) {
				for(int j = i - mid; j < MapSize - (i - mid);j++) {
					sum += Map[i][j] - '0';
				}
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
