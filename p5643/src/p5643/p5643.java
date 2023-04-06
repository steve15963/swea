package p5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p5643 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; T++ ){
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			//정방향
			ArrayList<Integer> NodeList[] = new ArrayList[N + 1];
			//역방향
			ArrayList<Integer> RNodeList[] = new ArrayList[N + 1];
			for(int i = 1 ; i <= N ; i++) {
				NodeList[i] = new ArrayList<Integer>();
				RNodeList[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0 ; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from   = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				NodeList [from].add(to);
				RNodeList[to  ].add(from);
			}
			
			for(int i = 0 ; i < N; i++) {
				boolean visit[] = new boolean[N];
				//정 방향 자식노드
				int child = CountDFS(NodeList, visit, 0, i);
				//역 방향 자식노드
				int rChild = CountDFS(RNodeList, visit, 0, i);
			}
			
		}

	}


	private static int CountDFS(ArrayList<Integer>[] nodeList, boolean[] visit,int count,int nodeNum) {
		for(int cur : nodeList[nodeNum]) {
			//다음 노드가 방문하지 않았다면 방문하기.
			if(!visit[cur])
				CountDFS(nodeList, visit, count + 1, cur);
		}
		return 0;
	}

}
