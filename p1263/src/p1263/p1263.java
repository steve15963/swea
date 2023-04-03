package p1263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1263 {
	static class Point{
		int to;
		int value;
		public Point(int to, int value) {
			super();
			this.to = to;
			this.value = value;
		}
	}
	static final int INF = Integer.MAX_VALUE/4;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
				
			int distance[][] = new int[N][N];
			
			
			//인접리스트를 최적해 테이블로 사용.
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N; j++) {
					distance[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && distance[i][j] == 0) {
						distance[i][j] = INF;
					}
				}
			}
			//경유지
			for(int k = 0; k < N; k++){
				//출발지
				for(int start = 0; start < N; start++) {
					// 경유지랑 출발지가 같으면 다음 출발지로.
					if(start == k) continue;
					// 도착지
					for(int end = 0; end < N; end++) {
						//도착지가 출발지나 경유지랑 같으면 다음 도착지로.
						if(start == end || k == end) continue;
						if(distance[start][end] > distance[start][k] + distance[k][end]){
							distance[start][end] = distance[start][k] + distance[k][end];
						}
					}
				}
			}
			System.out.printf("#%d %d\n",TC,print(distance, N));
		}

	}
	private static int print(int distance[][],int N) {
		int min = Integer.MAX_VALUE;
		for(int i = 0 ;i < N; i++) {
			int sum = 0;
			for(int j = 0 ; j < N; j++) {
				sum += distance[i][j];
			}
			min = Math.min(min,sum);
		}
		return min;
	}

}
