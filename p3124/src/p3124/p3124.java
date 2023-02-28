package p3124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p3124 {
	static class Node implements Comparable<Node>{
		int value;
		int to;
		public Node(int to, int value) {
			super();
			this.value = value;
			this.to =  to;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
				);
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int TC = 1 ; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Node> graphList[] = new ArrayList[V+1];
			boolean visit[] = new boolean[V+1];
			
			for(int i = 1 ; i <= V; i++) {
				graphList[i] = new ArrayList<Node>();
			}
			//그래프 인접 리스트 입력
			for(int i = 0 ; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to   = Integer.parseInt(st.nextToken());
				int value= Integer.parseInt(st.nextToken());
				graphList[from].add(new Node(to  , value));
				graphList[to  ].add(new Node(from, value));
			}
			long totalValue = 0;
			int cnt = 0;
			//우선순위 큐 생성
			PriorityQueue<Node> q = new PriorityQueue<Node>();
			// 첫 노드 생성하여 입력 단 가중치는0으로하여 BFS탐색의 시작
			q.add(new Node(1,0));
			while(!q.isEmpty()) {
				Node nextNode = q.poll();
				//방문한 노드는 이미 최소값의 엣지를 찾았으므로 제외
				if(visit[nextNode.to]) continue;
				// 방문처리
				visit[nextNode.to] = true;
				// 값 누산
				totalValue += nextNode.value;
				if(++cnt == V) break;
				//q에 그래프 인접리스트 모두 추가.
				q.addAll(graphList[nextNode.to]);
			}
			sb.append('#').append(TC).append(' ').append(totalValue).append('\n');
		}
		System.out.println(sb.toString());
	}
}
