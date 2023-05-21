package p2115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2115_self_1 {
	static int N,M,C,NM;
	static int map[][];
	static int maxMap[][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			NM = N - (M - 1);
			map = new int[N][N];
			maxMap = new int[N][NM];
			
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < NM; j++) {
					maxMap[i][j] = findMax(i,j,0,0,0);
				}
			}
			answer = 0;
			selectMax();
			System.out.println("#" + TC + " " + answer);
		} 

	}
	private static void selectMax() {
		// 1번 벌꿀
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < NM; j++) {
				// 2번 벌꿀
				for(int k = i ; k < N; k++) {
					int l = i == k ? j : 0;
					for(; l < NM; l++) {
						//같은 라인인데 길이보다 길 경우 겹치지 않음
						if(i == k && j + M > l ) continue;
						//라인이 다르거나 길이안에 포함되지 않은면 갱신 시도.
						
						answer = Math.max(answer, maxMap[i][j] + maxMap[k][l]);
//						System.out.println("answer : " + answer + ", " + (maxMap[i][j] + maxMap[k][l] )+ " = " + maxMap[i][j] + " + " + maxMap[k][l]);
					}
				}
			}
		}
	}
	private static int findMax(int i, int j,int sum,int multiSum, int count) {
		//기저 조건 M개를 모두 고려 한 경우 값 계산.
		if(count == M) {
			return multiSum;
		}
		//아직 모두 고려되지 않은 경우
		//만약 이번 선택이 가능한경우
		if(sum + map[i][j] <= C) {
			int value = map[i][j];
			//선택이 가능한 경우와 아닌경우를 따져서 큰 값을 돌려줌.
			return Math.max(
					findMax(i, j + 1, sum + value ,multiSum + ((int)Math.pow(value, 2)), count + 1), //선택해서 더한 경우
					findMax(i, j + 1, sum ,multiSum , count + 1) //선택하지 않아서 그냥 가는 경우
			);
		}
		//선택하면 안되는 경우
		else {
			return findMax(i, j + 1, sum ,multiSum , count + 1); //선택하지 않아서 그냥 가는 경우
		}
	}
}
