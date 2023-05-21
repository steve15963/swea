package p5650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5650 {
	//N x N 크기의 핀볼 게임판
	//정사각형 블록과 4가지 형태의 삼각형 블록
	//웜홀과 블랙홀이 존재
	//게임은 핀볼이 출발 위치로 돌아오거나, 블랙홀에 빠질 때 끝나게 되며 -> 기저 조건
	//점수는 벽이나 블록에 부딪힌 횟수 ( 웜홀을 통과하는 것은 점수에 포함되지 않는다.)
	
	
	//0 : 상,
	//1 : 우, 
	//2 : 하, 
	//3 : 좌
	static int up = 0;
	static int right = 1;
	static int down = 2;
	static int left = 3;
	static int wall[][] = {
			{    0,    0,    0,    0},
			{ down, left,right,   up},
			{right, left,   up, down},
			{ left, down,   up,right},
			{ down,   up, left,right},
			{ down, left,   up,right}
	};
	
	static int warmHole[][];
	static int T;
	static int N;
	static int map[][];
	static int answer;
	
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = { 0, 1, 0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; TC++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = 0;
			warmHole = new int[][]{
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
					{-9,-9,-9,-9},
			};
			//입력
			for(int i = 0 ; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num >= 6) {
						if(warmHole[num][0] == -9) {
							warmHole[num][0] = i;
							warmHole[num][1] = j;
						}else {
							warmHole[num][2] = i;
							warmHole[num][3] = j;
						}
					}
					map[i][j] = num;
				}
			}
			//탐색
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(map[i][j] == 0) {
						map[i][j] = -1;
						for(int d = 0 ; d < 4; d++) {
							move(i,j,d);
						}
						map[i][j] = 0;
					}
				}
			}
			System.out.println("#" + TC + " " + answer);
		}
		
		
		
	}

	private static void move(int nextY, int nextX, int d) {
		int score = 0;
		while(true) {
			nextY += dy[d];
			nextX += dx[d];
			//벽 밖으로 나간다면. 반대방향으로 튕김
			if(isCan(nextY,nextX)) {
				d = wall[5][d];
				score++;
				continue;
			}
			
			int num = map[nextY][nextX];
			//0이면 계속 이동
			if(num == 0) continue;
			
			//블랙홀이거나 시작지점이면 종료
			if(num == -1) {
				answer = Math.max(answer, score);
				return;
			}
			//벽이면
			if(num < 6) {
				d = wall[num][d];
				score++;
				continue;
			}
			//웜홀이면 이동
			else{
				//첫번째 입구랑 같으면
				if(
						warmHole[num][0] == nextY 
				        && 
				        warmHole[num][1] == nextX
				){
					int ty = warmHole[num][2];
					int tx = warmHole[num][3];
					nextY = ty;
					nextX = tx;
				}else {
					int ty = warmHole[num][0];
					int tx = warmHole[num][1];
					nextY = ty;
					nextX = tx;
				}
			}
		}
	}

	private static boolean isCan(int nextY, int nextX) {
		// TODO Auto-generated method stub
		return 0 > nextY ||nextY >= N || 0 > nextX || nextX >= N;
	}

}
