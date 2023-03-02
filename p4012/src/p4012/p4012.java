package p4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4012 {
	static int taste;
	static boolean visit[];
	static int map[][];
	static int N;
	static int N2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1 ; TC <= T; TC++) {
			N = Integer.parseInt(br.readLine());
			N2 = N/2;
			map = new int[N][N];
			visit = new boolean[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			taste = Integer.MAX_VALUE;
			
			select(0,0);
			System.out.println("#" + TC + " " + taste);
		}

	}
	private static void select(int cnt,int start) {
		if(cnt == N2) {
			int one = 0;
			int two = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visit[i] && visit[j]) one += map[i][j];
					if((!visit[i]) && (!visit[j])) two += map[i][j];
				}
			}
			taste = Math.min(
						taste, 
						Math.abs(
								one - two
						)
			);
			return;
		}
		for(int i = start ; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				select(cnt+1,i);
				visit[i] = false;
			}
		}
		
	}
}
