package p1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1486 {
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1 ; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int length[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N; i++) {
				length[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			DFS(0,0,N,B,length);
			System.out.printf("#%d %d\n", TC, min - B);
		}

	}

	private static void DFS(int cnt, int sum, int N, int B, int length[]) {
		if(cnt == N) {
			return;
		}
		//cnt 번째 인원이 빠진경우
		if(sum >= B) {
			min = Math.min(min, sum);
		}
		else DFS(cnt+1, sum, N, B, length);
		
		//cnt번째 인원이 들어온 경우
		if(sum + length[cnt] >= B) {
			min = Math.min(min, sum + length[cnt]);
		}
		else DFS(cnt+1, sum + length[cnt], N, B, length);
	}

}
