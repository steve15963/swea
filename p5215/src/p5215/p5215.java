package p5215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5215 {
	static int taste[];
	static int CAL[];
	static int MAX_CAL;
	static int buggur;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1 ; TC <= T; TC++) {
			String sData[] = br.readLine().split(" ");
			int N = Integer.parseInt(sData[0]);
			MAX_CAL = Integer.parseInt(sData[1]);
			taste 	= new int[N];
			CAL 	= new int[N];
			for(int i = 0; i < N; i++) {
				sData = br.readLine().split(" ");
				taste[i] = Integer.parseInt(sData[0]);
				CAL[i] = Integer.parseInt(sData[1]);
			}
			buggur = 0;
			recall(0,0,0,N);
			System.out.println("#" + TC + " " +buggur);
		}
		
	
	}
	public static void recall(int cnt,int totalTaste,int totalCal,int N) {
		if(totalCal > MAX_CAL)return;
		
		buggur = Math.max(buggur, totalTaste);
		
		if(cnt == N) return;
		
		recall(cnt + 1,totalTaste + taste[cnt], totalCal + CAL[cnt], N);
		recall(cnt+ 1,totalTaste, totalCal, N);

	}
}
