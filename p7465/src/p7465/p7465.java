package p7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7465 {
	static int root[];
	static void makeSet(int N) {
		root = new int[N+1];
		for(int i = 1; i <= N; i++) {
			root[i] = i;
		}
	}
	
	static int findSet(int A) {
		if(A == root[A]) return A;
		return findSet(root[A]);
	}
	
	static boolean union(int A, int B) {
		int aRoot = findSet(A);
		int bRoot = findSet(B);
		
		if(aRoot == bRoot) return false;
		root[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int TC = 1 ; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			makeSet(N);
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int aIndex = Integer.parseInt(st.nextToken());
				int bIndex = Integer.parseInt(st.nextToken());
				union(aIndex, bIndex);
			}
			int count = 0;
			for(int i = 1; i <= N; i++) {
				if(root[i] == i)
					count++;
			}
			sb.append('#').append(TC).append(' ').append(count).append('\n');
		}
		System.out.println(sb.toString());
	}
}
