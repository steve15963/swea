package p3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3289 {
	//Root 노드 배열
	static int root[];
	//노드의 랭크 배열
	static int rank[];
	static void makeSet(int N) {
		root = new int[N+1];
		rank = new int[N+1];
		//부모 노드 초기화
		for(int i = 1; i <= N; i++) {
			root[i] = i;
		}
	}
	// 부모노드 찾기(재귀)
	static int findSet(int A) {
		if(A == root[A]) return A;
		return findSet(root[A]);
	}
	// 부모노드를 찾으면 경로 압축
	static int findSet(int A,int rootB) {
		int t = root[A];
		root[A] = rootB;
		if(A == root[t]) return A;
		return findSet(t,rootB);
	}
	
	
	// 랭킹 합집합
	static boolean rankUnion(int A, int B) {
		int aRoot = findSet(A);
		int bRoot = findSet(B,aRoot);
		// 같은 집합이면 취소
		if(aRoot == bRoot) return false;
		//랭크가 a가 크면  a집합에 b집합을 합병
		if (rank[aRoot] > rank[bRoot]) {
            root[bRoot] = aRoot;
        //랭크가 b가 크면 b집합에 a집합을 합병 
        } else if (rank[aRoot] < rank[bRoot]) {
        	root[aRoot] = bRoot;
        //같다면 a집합에 b집합을 합볍하고 a집합 랭크 증가.
        } else {
        	root[bRoot] = aRoot;
            rank[aRoot]++;
        }
		return true;
	}
	
	// 패스 컴프레션 합집합
	static boolean pathUnion(int A, int B) {
		int aRoot = findSet(A);
		findSet(B,aRoot);
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int TC = 1 ; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 그룹 생성
			makeSet(N);
			sb.append('#').append(TC).append(' ');
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int aIndex = Integer.parseInt(st.nextToken());
				int bIndex = Integer.parseInt(st.nextToken());
				if(command == 0) {
					
					//두개 한번에 적용 방법은 생각중...
					// 두개중 1개를 주석 해제하여 사용
					//rankUnion(aIndex, bIndex);
					pathUnion(aIndex, bIndex);
				}
				else {
					int aRoot = findSet(aIndex);
					int bRoot = findSet(bIndex);
					if(aRoot == bRoot) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
