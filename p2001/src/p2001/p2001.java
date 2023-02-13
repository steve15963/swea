package p2001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class p2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T =  Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String SNM[] = br.readLine().split(" ");
			int N = Integer.parseInt(SNM[0]);
			int M = Integer.parseInt(SNM[1]);
			int TSUM[][] = new int[N+1][N+1];
			int VSUM[][] = new int[N+1][N+1];
			for(int i = 1; i <= N;i++) {
				String LineInput[] = br.readLine().split(" ");
				for(int j = 1; j <= N; j++) {
					int data = Integer.parseInt(LineInput[j-1]);
					VSUM[i][j] = VSUM[i][j - 1] + data;
					TSUM[i][j] = VSUM[i][j] + TSUM[i - 1][j];
				}
			}
			int parecheSize = M - 1;
			int findRange = N - parecheSize;
			int max = Integer.MIN_VALUE;
			for(int i = 1; i <= findRange ;i++) {
				for(int j = 1; j <= findRange ;j++) {
					max = Math.max(
							max,
							(
									TSUM[i + parecheSize][j + parecheSize] 
											- TSUM[i + parecheSize][j - 1] //상단제거
											- TSUM[i - 1][j + parecheSize] //하단제거
											+ TSUM[i - 1][j - 1]		   //중복된 데이터 다시 덧샘
							)
					);
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
