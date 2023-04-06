package p5607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5607 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		long factorial[] = new long[1000001];
		int factorialStatus = 1;
		factorial[1] = 1;
		for(int TC = 1; TC<= T; TC++) {
			 st = new StringTokenizer(br.readLine());
			 int N = Integer.parseInt(st.nextToken());
			 int R = Integer.parseInt(st.nextToken());
			 
			 if(factorialStatus < N) {
				 for(int i = factorialStatus + 1 ; i <= N; i++) {
					 factorial[i] = (factorial[i - 1] * i) % 1234567891;
				 }
				 factorialStatus = N;
			 }
			 
			 long bottom = (factorial[R] * factorial[N-R]) % 1234567891;// 1/a에서 a에 해당하는 값
			bottom = POW(bottom, 1234567891 -2);	
			 
			 sb.append("#").append(TC).append(" ").append(
					 (factorial[N] * bottom) % 1234567891
			).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static long POW(long man , long exp) {
		if(exp == 0) return 1;
		if(exp == 1) return man;
		if(exp % 2 == 0) {
			long tmp = POW(man,exp/2);
			return (tmp * tmp) % 1234567891;
		}
		long tmp = POW(man,exp-1);
		return (tmp * man) % 1234567891;
	}

}
