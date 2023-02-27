package p5644;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5644 {
	static class BC{
		int X;
		int Y;
		int C;
		int P;
		int userCount = 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int userACommand[] = new int[M];
			int userBCommand[] = new int[M];
			
			Point userA = new Point(1, 1);
			Point userB = new Point(10,10);
			
			st = new StringTokenizer(br.readLine());
			input(userACommand,st);
			st = new StringTokenizer(br.readLine());
			input(userBCommand,st);
			
			
			//InputBC(br,st,map,A,M);
			BC bc[] = new BC[A];
			for(int i = 0; i < A; i ++) {
				bc[i] = new BC();
				st = new StringTokenizer(br.readLine());
				bc[i].X = Integer.parseInt(st.nextToken());
				bc[i].Y = Integer.parseInt(st.nextToken());
				bc[i].C = Integer.parseInt(st.nextToken());
				bc[i].P = Integer.parseInt(st.nextToken());
			}
			
			int charge = 0;
			final int dy[] = {0,-1, 0, 1, 0};
			final int dx[] = {0, 0, 1, 0,-1};
			for(int i = 0 ; i < M ; i++) {
				charge += FindMaximumCharge(bc, userA, userB);
				int any = userA.y + dy[userACommand[i]];
				int anx = userA.x + dx[userACommand[i]];
				int bny = userB.y + dy[userBCommand[i]];
				int bnx = userB.x + dx[userBCommand[i]];
				if(isCan(any, anx)) {
					userA.y = any;
					userA.x = anx;
				}
				if(isCan(bny, bnx)) {
					userB.y = bny;
					userB.x = bnx;
				}
				System.out.println("AY : " + userA.y + ", AX : " + userA.x);
				System.out.println("BY : " + userB.y + ", BX : " + userB.x);
				System.out.println("charge : " + charge + ", i : " + i);
				System.out.println();
				
			}
			
			
			System.out.println("#"+ TC + " ");
		}

	}
	
	private static int FindMaximumCharge(BC[] bc, Point userA, Point userB) {
		int aMax = -1;
		int bMax = -1;
		for(BC b:bc) {
			int userADist = Math.abs(b.X - userA.x) + Math.abs(b.Y - userA.y);
			if(b.C >= userADist && b.P > aMax) { // 충전 범위에 있으면.
				aMax = b.P;
			}
			int userBDist = Math.abs(b.X - userB.x) + Math.abs(b.Y - userB.y);
			
		}
		return 0;
	}

	private static boolean isCan(int y, int x) {
		return 1 <= y && y <= 10 && 1 <= x &&  x <= 10;
	}
	private static void input(int[] user, StringTokenizer st) {
		int i = 0;
		while(st.hasMoreTokens()) {
			user[i++] = Integer.parseInt(st.nextToken());
		}
	}

}
