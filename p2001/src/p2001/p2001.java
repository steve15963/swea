package p2001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class p2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =  Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String SNM[] = br.readLine().split(" ");
			int N = Integer.parseInt(SNM[0]);
			int M = Integer.parseInt(SNM[1]);
			int MAP[][]  = new int[N+1][N+1];
			int TSUM[][] = new int[N+1][N+1];
			int VSUM[][] = new int[N+1][N+1];
			int HSUM[][] = new int[N+1][N+1];
			for(int i = 1; i <= N;i++) {
				String LineInput[] = br.readLine().split(" ");
				for(int j = 1; j <= N; j++) {
					MAP[i][j] = Integer.parseInt(LineInput[j-1]);
					VSUM[i][j] = VSUM[i][j - 1] + MAP[i][j];
					TSUM[i][j] = VSUM[i][j] + VSUM[i - 1][j];
					HSUM[i][j] = HSUM[i - 1][j] + MAP[i][j]; 
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
											- HSUM[i][j - 1] 
											- VSUM[i - 1][j]
											+ MAP[i - 1][j - 1]
							)
					);
					System.out.println(max);
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}

}
