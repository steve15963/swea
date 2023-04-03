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
//			for(int i = 0 ; i < N;i++) {
//				Arrays.fill(distance[i], INF);
//			}
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N; j++) {
					distance[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && distance[i][j] == 0) {
						distance[i][j] = INF;
					}
				}
			}
			
//			int size = N * N;
//			ArrayList<Point> adjList[] = new ArrayList[N];
//			for(int i = 0 ; i < N ; i++) {
//				adjList[i] = new ArrayList<Point>();
//			}
//			
//			for(int i = 0 ; i < size; i++) {
//				int value = Integer.parseInt(st.nextToken());
//				if(value != 0) {
//					int from = i / N;
//					int to = i % N;
//					adjList[from].add(new Point(to, value));	
//				}
//			}
			
			//경유지
			for(int k = 0; k < N; k++){
				//출발지
				for(int s = 0; s < N; s++) {
					// 경유지랑 출발지가 같으면 다음 출발지로.
					if(s == k) continue;
					// 도착지
					for(int e = 0; e < N; e++) {
						//도착지가 출발지나 경유지랑 같으면 다음 도착지로.
						if(s == e || k == e) continue;
						if(distance[s][e] > distance[e][k] + distance[k][e]){
							distance[s][e] = distance[s][k] + distance[k][e];
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
