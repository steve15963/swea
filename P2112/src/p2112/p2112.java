package p2112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2112 {
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1 ; TC <= T ; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[D][W];
			int Chemical[] = new int[D];
			
			Arrays.fill(Chemical, 2);
			
			for(int i = 0; i < D; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			DFSChemicalProgress(0,0,map,Chemical, D, W, K);
			System.out.printf("#%d %d\n",TC,min);
		}
	}

	private static void DFSChemicalProgress(int cnt,int c, int[][] map, int[] Chemical, int d, int w, int k) {
		// TODO Auto-generated method stub
		if(cnt >= d) {
			return;
		}
		//A처리
		Chemical[cnt] = 0;
		if(CheckSpec(map, Chemical, d, w, k)) {
			min = Math.min(min, c+1);
		}
		else
			DFSChemicalProgress(cnt+1, c+1, map, Chemical, d, w, k);
		//B처리
		Chemical[cnt] = 1;
		if(CheckSpec(map, Chemical, d, w, k)) {
			min = Math.min(min, c+1);
		}
		else DFSChemicalProgress(cnt+1, c+1, map, Chemical, d, w, k);
		
		//아무것도 처리 안함.
		Chemical[cnt] = 2;
		if(CheckSpec(map, Chemical, d, w, k)) {

			min = Math.min(min, c);
		}
		else DFSChemicalProgress(cnt+1, c, map, Chemical, d, w, k);
	}

	private static boolean CheckSpec(int[][] map, int[] Chemical, int d, int w, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		int origin = 0;
		for(int i = 0 ; i < w; i++) {
			origin = map[0][i];
			count = 0;
			boolean flag = true;
			for(int j = 0 ; j< d; j++) {
				//약품 처리를 안했으면 기존 값과 오리진 값이 같은경우
				if(Chemical[j] == 2 && map[j][i] == origin) {
					count++;
				}
				//약품 처리를 한 경우 약품 값과 기준 값이 같은 경우
				else if(Chemical[j] == origin) {
					count++;
				}
				//값이 다른경우 초기화하고 값을 변경.
				else if( Chemical[j] == 2) {
					count = 1;
					origin = map[j][i];
				}
				else {
					count = 1;
					origin = Chemical[j];
				}
				//만약 K번만큼 일치하면 품질 통과.
				if(count == k) {
					flag = false;
					break;
				}
			}
			// 내부에서 찾지 못한 경우
			if(flag) return false;
		}
		//모두 찾아서 완료가 된 경우.
		return true;
	}



}
