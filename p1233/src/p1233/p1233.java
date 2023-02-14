package p1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p1233 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int TC = 1; TC <= 10; TC++) {
			int N = Integer.parseInt(br.readLine());
			
			int answer = 1;

			for(int i = 1; i <= N; i++) {
				StringTokenizer st =  new StringTokenizer(br.readLine());
				
				//정점 번호는 의미가 없으므로 제거.
				st.nextToken();
				
				//node의 값을 받아와서.
				char node = st.nextToken().charAt(0); 
				
				//3번,4번 값이 있으면 자식 노드가 있는데
				if(st.hasMoreTokens()) { // 단말 노드가 아닐 때 
					//자식 노드가 있어도 값이 연산자가 아닌 숫자라면.
					//연산 오류가 발생한다.
					if(node >= '0' && node <= '9') {
						answer = 0;
						//답은 필요 없는 데이터를 입력 버퍼에서 뺴준다.
						for(int j = i; j < N;j++) {
							br.readLine();
						}
						// 진행 할 필요가 없으므로 멈춘다.
						break;
					}
				} else { // 단말 노드일 때 
					if(node < '0' || node > '9') { // 숫자여야 함 
						answer = 0;
						//답은 필요 없는 데이터를 입력 버퍼에서 뺴준다.
						for(int j = i; j < N;j++) {
							br.readLine();
						}
						// 진행 할 필요가 없으므로 멈춘다.
						break;
					}
				}
			}
			sb.append("#" + TC + " " + answer + '\n');
		}
		System.out.println(sb.toString());
	}

}
