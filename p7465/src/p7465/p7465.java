package p7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7465 {
	static int root[];
	/**
	 * 부분합을 만들어주는 함수
	 * @param N N개 만큼의 부분함 Array를 생성함
	 */
	static void makeSet(int N) {
		root = new int[N+1];
		for(int i = 1; i <= N; i++) {
			root[i] = i;
		}
	}
	
	/**
	 * A노드의 대표자를 찾음
	 * @param 찾고자하는 대표의 소속원을 입력
	 * @return
	 */
	static int findSet(int A) {
		if(A == root[A]) return A;
		return findSet(root[A]);
	}
	//A그룹에 B그룹을 합집합
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
			
			
			// 부분합을 생성하고
			makeSet(N);
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int aIndex = Integer.parseInt(st.nextToken());
				int bIndex = Integer.parseInt(st.nextToken());
				// 관계를 입력받아 그룹화 시키며
				union(aIndex, bIndex);
			}
			int count = 0;
			for(int i = 1; i <= N; i++) {
				// 자기 index와 대표자가 일치하는 사람을 찾아 Group을 카운트한다.
				if(root[i] == i)
					count++;
			}
			sb.append('#').append(TC).append(' ').append(count).append('\n');
		}
		System.out.println(sb.toString());
	}
}
