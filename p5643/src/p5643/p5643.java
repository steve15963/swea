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
			
			
			ArrayList<Integer> NodeList[] = new ArrayList[N + 1];
			ArrayList<Integer> RNodeList[] = new ArrayList[N + 1];
			for(int i = 1 ; i <= N ; i++) {
				NodeList[i] = new ArrayList<Integer>();
				RNodeList[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0 ; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from   = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				NodeList[from].add(to);
				
			}
			
			int child = CountChild()
			
		}

	}

}
