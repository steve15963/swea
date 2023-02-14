package p9229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9229 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= T; TC++) {
			String sData[] = br.readLine().split(" ");
			
			int N = Integer.parseInt(sData[0]);
			int M = Integer.parseInt(sData[1]);
			
			int data[] = new int[N];
			sData = br.readLine().split(" ");
			for(int i = 0 ; i < N; i++) {
				data[i] = Integer.parseInt(sData[i]);
			}
			
			int max = -1;
			for(int i = 0 ; i < N; i++) {
				for(int j = i + 1; j < N ; j++) {
					if(data[i] + data[j] <= M)
						max = Math.max(max, data[i] + data[j]);
				}
			}
			System.out.println("#" + TC + " " + max);
		}
	}
}
