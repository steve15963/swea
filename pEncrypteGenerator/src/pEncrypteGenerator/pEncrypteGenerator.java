package pEncrypteGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class pEncrypteGenerator {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> LLI = new LinkedList<Integer>();
		for(int i = 1 ; i <= 10;i++) {
			br.readLine();
			String sData[] = br.readLine().split(" ");
			for(int j= 0 ; j < 8; j++ ) {
				LLI.add(Integer.parseInt(sData[j]));
			}
			int j = 0;
			while(true) {
				int temp = LLI.pollFirst() - ((j % 5) + 1);
				if( temp <= 0) break;
				LLI.add(temp);
				j++;
			}
			sb.append('#').append(i);
			while(!LLI.isEmpty()) {
				sb.append(" ").append(LLI.pollFirst());
			}
			sb.append(" 0").append('\n');
		}
		System.out.println(sb.toString());
	}
}
