package p2117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p2117_self_1 {

	//파란색 부분과 같이 마름모 모양의 영역에서만 제공된다 -= BFS의 동심원 모양
	//홈방범 서비스를 제공하기 위해서는 운영 비용이 필요
	//서비스 영역의 크기 K 가 커질수록 운영 비용이 커진다. -> 서비스 영역 = BFS LEVEL
	// 운영 비용 = K * K + (K - 1) * (K - 1)
	//K 는 1 이상의 정수
	//홈방범 서비스를 제공받는 집들은 각각 M의 비용을 지불
	
	//N은 5 이상 20 이하의 정수이다. (5 ≤ N ≤ 20)
	//M은 1 이상 10 이하의 정수
	static int N,K,M,Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//집 리스트
			List<int[]> zipList = new ArrayList<>();
			
			
			//맵 크기
			N = Integer.parseInt(st.nextToken());
			
			//집당 지불 비용
			M = Integer.parseInt(st.nextToken());
			
			//집 위치 입력 받기
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					if(Integer.parseInt(st.nextToken()) == 1){
						zipList.add(new int[] {i,j});
					}
				}
			}
			

			int listSize = zipList.size();
			Answer = 0;
			
			//모든집 순회하며
			for(int y = 0 ; y < N; y++) {
				for(int x = 0 ; x < N; x++) {
					//현 위치에서 모두를 덮을 수 있는 최대 사각형을 크기를 구하고.
					int maxK = Math.max(y , N - y) + Math.max(x,  N - x) - 1;
					//1부터 K까지 모든 경우를 고려하여
					for(int k = 1; k <= maxK; k++) {
						
						// 현재 크기에서 비용을 계산하고
						int cost = k*k + (k-1)*(k-1);
						
						int count = 0;
						// 모든 집에 대해서
						// 맨해튼 거리가 K가 1 ~ maxK사이에 포함되는 수를 카운트하여 최대 카운트 값 찾기.
						for (int i = 0; i < listSize; i++) {
							//만약 맨해튼 거리가 K보다 작을 경우 포함됨.
							if( Math.abs( zipList.get(i)[0] - y) + Math.abs( zipList.get(i)[1] - x) < k )
								count++;
						}
						//만약 여태 계산한 값보다 큰 이득이 난다면 교환.(단 같은 이득이라면 더 넓은 서비스를 제공.)
						if(count * M >= cost ) Answer = Math.max(Answer, count);
					}
				}
			}
			System.out.println("#" + TC + " " + Answer);
		}
	}

}
