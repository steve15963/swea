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
			//�Ѷ��ξ� ����
			for(int i = 0 ; i<MapSize;i++) {
				Map[i] = br.readLine().toCharArray();
			}
			
			// �̹� ���� �⺻�� ����.
			int sum = 0;
			int mid = MapSize/2;
			
			// ��� ����
			for(int i = 0; i < mid; i++) {
				for(int j = mid - i; j<=mid+i;j++) {
					sum += Map[i][j] - '0';
				}
			}
			//�Ϻ� ����
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
